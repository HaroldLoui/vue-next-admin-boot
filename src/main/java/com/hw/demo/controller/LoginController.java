package com.hw.demo.controller;

import com.hw.demo.common.BaseController;
import com.hw.demo.entity.req.LoginForm;
import com.hw.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/signIn")
    public String signIn(@RequestBody @Validated LoginForm loginForm) {
        String token = loginService.signIn(loginForm);
        return ok("登录成功", token);
    }
}
