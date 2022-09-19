package com.liaobei.dao.inter;

import com.liaobei.pojo.Wechat;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WechatMapper {

    @Select("select * from wechat")
    List<Wechat> getAllWechat();

    @Insert("insert into wechat(username,avatar,content,date,address) values(#{username},#{avatar},#{content},#{date},#{address})")
    int insertWechat(Wechat wechat);
}
