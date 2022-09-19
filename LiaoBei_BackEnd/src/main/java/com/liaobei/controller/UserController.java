package com.liaobei.controller;

import com.liaobei.pojo.Friend;
import com.liaobei.pojo.User;
import com.liaobei.service.UserService;
import com.liaobei.util.Md5PwdEncoder;
import com.liaobei.util.MySessionContext;
import com.liaobei.util.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author whr
 * @description 用户控制器，返回json格式
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Md5PwdEncoder md5PwdEncoder;

//    注销
    @RequestMapping("/logout")
    public void logout(String sessionid){
        HttpSession session = MySessionContext.getSession(sessionid);
        session.invalidate();
        System.out.println("用户已退出登录");
    }

//    微信小程序直接登录
    @RequestMapping("/loginD")
    public Boolean loginD(@RequestBody Map map,HttpServletRequest request){
        String sessionid = (String) map.get("sessionid");
        HttpSession session = null;
        if(sessionid!=null){
            session = MySessionContext.getSession(sessionid);
            if(session==null){
                session = request.getSession();
            }
        }else {
            session = request.getSession();
        }
        String openid = (String) map.get(SysConstant.OPENID);
        String openid1 = null;
        if(session.getAttribute(SysConstant.OPENID)!=null){
            openid1 = (String) session.getAttribute(SysConstant.OPENID);
        }
//        判断是否是同一个登录用户
        if(openid1!=null && openid.equals(openid1)){
            return true;
        }
        session.setAttribute(SysConstant.OPENID,openid);
        String session_key = (String) map.get("session_key");
        String nickName = (String) map.get("nickName");
        String avatarUrl = (String) map.get("avatarUrl");
        Integer gender = (Integer) map.get("gender");
        User user = new User();
        user.setUsername(nickName);
        user.setAvatar(avatarUrl);
        user.setSex(String.valueOf(gender));
        int row = userService.insertUserToReg(user);
        if(row>0){
            session.setAttribute(SysConstant.SESSION_KEY,session_key);
            session.setAttribute(SysConstant.USER,user);
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping("/login")
//    @RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；
    public User login(@RequestBody Map<String,String> map, HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        String telNumber=map.get("telNumber");
        String password1=map.get("password");
        String password = md5PwdEncoder.encodePassword(password1);
        User user = userService.findUserToLogin(telNumber, password);
        if(user!=null){
            session.setAttribute(SysConstant.USER,user);
            return user;
        }
        return null;
    }

//    通过id查找用户
    @RequestMapping("/getUserById")
    public User getUserById(Integer id){
        User user = userService.findUserById(id);
        return user;
    }
//    通过手机号查询用户是否存在，可用于注册重复性查询
    @RequestMapping("/findUserByTel")
    public Boolean findUserByTel(String telNumber){
        User user = userService.findUserByTel(telNumber);
        if(user!=null){
            return true;
        }else{
            return false;
        }
    }

//    通过手机号查找用户，用来查找好友是否存在
    @RequestMapping("/searchUserByTel")
    public User searchUserByTel(String telNumber){
        User user = userService.findUserByTel(telNumber);
        if(user!=null){
            return user;
        }else{
            return null;
        }
    }
//    修改sendMsg值，添加好友
    @RequestMapping("/updateSendMsg")
    public Boolean updateSendMsg(Integer send_msg,Integer id){
        int row = userService.updateSendMsg(send_msg, id);
        if(row>0){
            return true;
        }
        return false;
    }
//    修改sendId值，添加好友
    @RequestMapping("/updateSendId")
    public Boolean updateSendId(Integer send_id,Integer id){
        int row = userService.updateSendId(send_id, id);
        if(row>0){
            return true;
        }
        return false;
    }

//    获取sendMsg值，添加好友
    @RequestMapping("/getSendMsg")
    public int getSendMsg(Integer id){
        Integer sendMsg = userService.getSendMsg(id);
        return sendMsg;
    }
    //    获取sendId值，添加好友
    @RequestMapping("/getSendId")
    public int getSendId(Integer id){
        return userService.getSendId(id);
    }

//    将好友映射信息插入表中
    @RequestMapping("/insertFriend")
    public Boolean insertFriend(Friend friend){
        int row = userService.insertFriend(friend);
        if(row>0){
            return true;
        }
        return false;
    }

    /**
     * @param id 要查找好友用户的id
     * @return 返回此用户的所有好友
     */
    @RequestMapping("/findAllFriend")
    public List<User> findAllFriend(Integer id){
        List<User> userList = userService.findFriendsByIds(id);
        if(userList!=null){
            return userList;
        }
//        如果此用户没有好友，将返回null
        return userList;
    }

//    查找此条好友信息是否在friend表中存在
    @RequestMapping("/findFriendId")
    public int findFriendId(Integer mainId,Integer friendId){
        int row = userService.findFriendId(mainId,friendId);
        return row;
    }

//    实现注册功能
    @RequestMapping("/register")
    public int register(@RequestBody User user,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user1 = userService.findUserByTel(user.getTelNumber());
        if(user1!=null){
            return -1;
        }
        user.setPassword(md5PwdEncoder.encodePassword(user.getPassword()));
        int row = userService.insertUserToReg(user);
        if(row>0){
            session.setAttribute(SysConstant.USER,user);
        }
        return user.getId();

    }

//    修改用户的所有个人信息
    @RequestMapping("/updateData")
    public User updateUserData(@RequestBody User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(user);
        int row = userService.updateUser(user);
        User user1 = null;
        if(row>0){
            user1 = userService.findUserById(user.getId());
            session.setAttribute(SysConstant.USER,user1);
        }
        return user1;
    }

//    找回密码
    @RequestMapping("/updatePwdByTel")
    public Boolean updatePwdByTel(@RequestBody Map map){
        String password = (String) map.get("password");
        String telNumber = (String) map.get("telNumber");
        int row = userService.updatePwd(md5PwdEncoder.encodePassword(password), telNumber);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping("/demo")
    public void getSession(HttpServletRequest request,String sessionid){
        HttpSession session = MySessionContext.getSession(sessionid);
        System.out.println(session);
        System.out.println(sessionid);
        Object attribute = session.getAttribute(SysConstant.USER);
        System.out.println(attribute);
    }
}
