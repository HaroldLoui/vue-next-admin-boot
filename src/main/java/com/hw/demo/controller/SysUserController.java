package com.hw.demo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hw.demo.common.BaseController;
import com.hw.demo.entity.SysUser;
import com.hw.demo.entity.req.SysUserReq;
import com.hw.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SaCheckLogin
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/list")
    public String getPage(SysUserReq req) {
        Page<SysUser> page = sysUserService.getPage(req);
        return ok("查询成功", page);
    }

    @PostMapping("/save")
    public String save(@RequestBody @Validated SysUser sysUser) {
        sysUserService.saveUser(sysUser);
        return ok("新增用户信息成功");
    }

    @PutMapping("/update")
    public String update(@RequestBody @Validated SysUser sysUser) {
        sysUserService.updateUser(sysUser);
        return ok("修改用户信息成功");
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        sysUserService.deleteUser(id);
        return ok("删除用户信息成功");
    }
}
