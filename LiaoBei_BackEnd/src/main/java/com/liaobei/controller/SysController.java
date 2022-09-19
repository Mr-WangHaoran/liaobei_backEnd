package com.liaobei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author whr
 * @description 服务器启动页面跳转，可以用作后台跳转
 */
@Controller
public class SysController {

    @RequestMapping("/")
    public String ServerInit(){
        return "index";
    }


}
