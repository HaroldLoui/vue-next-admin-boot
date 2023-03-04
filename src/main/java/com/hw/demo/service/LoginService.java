package com.hw.demo.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.hw.demo.entity.req.LoginForm;

public interface LoginService {

    SaTokenInfo signIn(LoginForm loginForm);

    void signOut();
}
