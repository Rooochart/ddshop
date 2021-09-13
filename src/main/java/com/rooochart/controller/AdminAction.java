package com.rooochart.controller;

import com.rooochart.pojo.Admin;
import com.rooochart.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAction {

  /**
   * 注意  在所有界面层一定要有业务层逻辑对象  由Spring注入
   */
  @Autowired
  AdminService adminService;

  //实现登录判定并进行相应的跳转
  @RequestMapping("/login")
  public String login(String name, String pwd, HttpServletRequest request) {
    Admin admin = adminService.login(name, pwd);
    if (admin != null) {
      //登陆成功 ，设置友好界面
      request.setAttribute("admin", admin);
      return "main";
    } else {
      request.setAttribute("errmsg", "用户名或密码不正确");  //login.jsp ${errmsg}
      return "login";
    }

  }
}