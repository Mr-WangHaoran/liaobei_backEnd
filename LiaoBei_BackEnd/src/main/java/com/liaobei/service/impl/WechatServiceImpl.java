package com.liaobei.service.impl;

import com.liaobei.dao.inter.WechatMapper;
import com.liaobei.pojo.Wechat;
import com.liaobei.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author whr
 * @description 朋友圈继承类
 */
@Service
@Transactional
public class WechatServiceImpl implements WechatService {

    @Autowired
    private WechatMapper wechatMapper;

    public List<Wechat> getAllWechat() {
        return wechatMapper.getAllWechat();
    }

    public int insertWechat(Wechat wechat) {
        return wechatMapper.insertWechat(wechat);
    }
}
