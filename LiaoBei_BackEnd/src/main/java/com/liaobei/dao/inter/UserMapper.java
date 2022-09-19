package com.liaobei.dao.inter;

import com.liaobei.pojo.Friend;
import com.liaobei.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    int insertOpenId(@Param("id") Integer id,@Param("openId") String openId);

    @Select("select * from user where id=#{id}")
    User findUserById(Integer id);
//    简单语句直接用注解方式实现
    @Select("select * from user where telNumber=#{telNumber} and password=#{password}")
    User findUserByTelAndPwd(@Param("telNumber") String telNumber, @Param("password") String password);

    int insertUser(User user);

    int updateUserData(User user);

    @Update("update user set password = #{pwd} where telNumber=#{telNumber}")
    int updatePwd(@Param("pwd") String pwd,@Param("telNumber") String telNumber);

    @Select("select * from user where telNumber = #{telNumber}")
    User findUserByTel(String telNumber);

    @Insert("update user set send_msg = #{sendMsg} where id = #{id}")
    int updateSendMsg (@Param("sendMsg") Integer sendMsg,@Param("id")Integer id);

    @Insert("update user set send_id = #{sendId} where id = #{id}")
    int updateSendId(@Param("sendId")Integer sendId,@Param("id")Integer id);

    @Insert("insert into friend values(#{mainId},#{friendId})")
    int insertFriend(Friend friend);

    @Select("select friend_id from friend where main_id = #{id}")
    List<Integer> findFriendsIds(Integer id);

    List<User> findFriendsByIds(List<Integer> ids);

    @Select("select send_msg from user where id = #{id}")
    Integer getSendMsg(Integer id);

    @Select("select send_id from user where id = #{id}")
    Integer getSendId(Integer id);

    @Select("select count(*) from friend where main_id = #{mainId} and friend_id = #{friendId}")
    int findFriendId(@Param("mainId") Integer mainId,@Param("friendId") Integer friendId);

}
