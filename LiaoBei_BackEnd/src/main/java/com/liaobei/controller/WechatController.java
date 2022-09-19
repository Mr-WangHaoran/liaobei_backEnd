package com.liaobei.controller;

import com.liaobei.pojo.Wechat;
import com.liaobei.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author whr
 * @description 朋友圈控制器，只返回json格式字符串
 */
@RestController
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private WechatService wechatService;

    @RequestMapping("/getAllChat")
    public List<Wechat> getAllChat(){
        return wechatService.getAllWechat();
    }

    @RequestMapping("insertWechat")
    public int insertWechat(@RequestBody Wechat wechat){
        return wechatService.insertWechat(wechat);
    }
}
