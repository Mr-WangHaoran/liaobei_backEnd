package com.liaobei.service;

import com.liaobei.pojo.Wechat;

import java.util.List;

public interface WechatService {

   public List<Wechat> getAllWechat();

   int insertWechat(Wechat wechat);
}
