package com.hw.demo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.SaTokenInfo;
import com.hw.demo.common.BaseController;
import com.hw.demo.entity.req.LoginForm;
import com.hw.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @SaIgnore
    @PostMapping("/signIn")
    public String signIn(@RequestBody @Validated LoginForm loginForm) {
        SaTokenInfo token = loginService.signIn(loginForm);
        return ok("登录成功", token);
    }

    @SaCheckLogin
    @GetMapping("/signOut")
    public String signOut() {
        loginService.signOut();
        return ok("登出成功");
    }
}
