package com.hw.demo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hw.demo.common.BaseController;
import com.hw.demo.entity.SysRole;
import com.hw.demo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SaCheckLogin
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/list")
    public String getList(int pageNum, int limit) {
        Page<SysRole> page = sysRoleService.getPage(pageNum, limit);
        return ok("查询成功", page);
    }

    @PostMapping("/save")
    public String save(@RequestBody @Validated SysRole sysRole) {
        sysRoleService.save(sysRole);
        return ok("新增成功");
    }

    @PutMapping("update")
    public String update(@RequestBody @Validated SysRole sysRole) {
        sysRoleService.updateById(sysRole);
        return ok("新增成功");
    }
}
