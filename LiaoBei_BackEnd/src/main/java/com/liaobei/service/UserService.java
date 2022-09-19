package com.liaobei.service;

import com.liaobei.pojo.Friend;
import com.liaobei.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    int insertOpenId(Integer id,String openId);

    User findUserById(Integer id);

    User findUserToLogin(String telNumber,String password);

    int insertUserToReg(User user);

    int updateUser(User user);

    User findUserByTel(String telNumber);

    int updatePwd(String pwd,String telNumber);

    int updateSendMsg (Integer sendMsg,Integer id);

    int updateSendId (Integer sendId,Integer id);

    int insertFriend(Friend friend);

    List<User> findFriendsByIds(Integer id);

    Integer getSendMsg(Integer id);

    Integer getSendId(Integer id);

    int findFriendId(Integer mainId,Integer friendId);
}
