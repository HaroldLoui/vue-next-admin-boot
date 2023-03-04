package com.hw.demo.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.SecureUtil;
import com.hw.demo.entity.SysUser;
import com.hw.demo.entity.req.LoginForm;
import com.hw.demo.exception.LoginErrorException;
import com.hw.demo.service.LoginService;
import com.hw.demo.service.SysUserService;
import com.hw.demo.utils.SaSessionUtils;
import com.hw.demo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public SaTokenInfo signIn(LoginForm loginForm) {
        // 1.校验验证码是否正确

        // 2.检查账号密码是否正确
        SysUser sysUser = sysUserService.lambdaQuery()
                .eq(SysUser::getUsername, loginForm.getUsername())
                .one();
        if (sysUser == null) {
            throw new LoginErrorException("该用户名未注册");
        }
        if (StringUtils.notEqualsIgnoreCase(sysUser.getPassword(), SecureUtil.md5(loginForm.getPassword()))) {
            throw new LoginErrorException("密码错误");
        }
        // sa-token登录
        StpUtil.login(sysUser.getId());
        // 保存用户信息到SaSession里
        SaSessionUtils.setCurrentUser(sysUser);
        // 4.获取token信息并返回
        return StpUtil.getTokenInfo();
    }

    @Override
    public void signOut() {
        StpUtil.logout(StpUtil.getLoginId());
        SaSessionUtils.clear();
    }
}
