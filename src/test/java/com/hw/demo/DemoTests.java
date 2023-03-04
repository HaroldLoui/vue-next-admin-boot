package com.hw.demo;

import cn.hutool.crypto.SecureUtil;
import com.hw.demo.entity.SysUser;
import com.hw.demo.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoTests {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void test1() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        sysUser.setPassword(SecureUtil.md5("123456").toUpperCase());
        sysUserService.save(sysUser);
    }

    @Test
    public void test2() {

    }

}
