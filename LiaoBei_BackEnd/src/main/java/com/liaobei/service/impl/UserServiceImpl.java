package com.liaobei.service.impl;

import com.liaobei.dao.inter.UserMapper;
import com.liaobei.pojo.Friend;
import com.liaobei.pojo.User;
import com.liaobei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author whr
 * @description 用户服务
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public int insertOpenId(Integer id, String openId) {
        return userMapper.insertOpenId(id,openId);
    }

    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    public User findUserToLogin(String telNumber, String password) {
        return userMapper.findUserByTelAndPwd(telNumber, password);
    }

    public int insertUserToReg(User user) {
        return userMapper.insertUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUserData(user);
    }

    public User findUserByTel(String telNumber) {
        return userMapper.findUserByTel(telNumber);
    }

    public int updatePwd(String pwd, String telNumber) {
        return userMapper.updatePwd(pwd,telNumber);
    }

    public int updateSendMsg(Integer sendMsg, Integer id) {
        return userMapper.updateSendMsg(sendMsg,id);
    }

    public int updateSendId(Integer sendId, Integer id) {
        return userMapper.updateSendId(sendId, id);
    }

    public int insertFriend(Friend friend) {
        return userMapper.insertFriend(friend);
    }

//    查找出所有好友列表
    public List<User> findFriendsByIds(Integer id) {
        List<Integer> ids = userMapper.findFriendsIds(id);
        if(ids.size()>0){
            return userMapper.findFriendsByIds(ids);
        }
        return null;
    }

    public Integer getSendMsg(Integer id) {
        return userMapper.getSendMsg(id);
    }

    public Integer getSendId(Integer id) {
        return userMapper.getSendId(id);
    }

    public int findFriendId(Integer mainId,Integer friendId){
        return  userMapper.findFriendId(mainId, friendId);
    }
}
