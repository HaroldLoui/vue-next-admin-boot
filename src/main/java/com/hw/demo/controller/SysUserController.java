package com.hw.demo.controller;

import com.hw.demo.common.BaseController;
import com.hw.demo.component.SnowFlakeIdWorker;
import com.hw.demo.entity.SysUser;
import com.hw.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SnowFlakeIdWorker idWorker;

    @PostMapping("/add")
    public void test(@RequestBody SysUser sysUser) {
        System.out.println(sysUser);
        sysUserService.save(sysUser);
    }

    @GetMapping("/user")
    public String getUser() {
        SysUser sysUser = new SysUser();
        sysUser.setId(idWorker.nextId());
        sysUser.setId(1L);
        sysUser.setUsername("username");
        sysUser.setPassword("password");
        sysUser.setPhone("15112345678");
        sysUser.setEmail("1511234567@qq.com");
        sysUser.setCreateTime(LocalDateTime.now());
        return ok("success", sysUser);
    }
}
