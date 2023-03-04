package com.hw.demo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.hw.demo.common.BaseController;
import com.hw.demo.entity.SysMenu;
import com.hw.demo.entity.resp.SysMenuResp;
import com.hw.demo.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SaCheckLogin
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/list")
    public String getMenuList() {
        List<SysMenuResp> results = sysMenuService.getMenuList();
        return ok("查询菜单列表成功", results);
    }

    @PostMapping("/save")
    public String save(@RequestBody SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return ok("新增菜单成功");
    }

    @PutMapping("/update")
    public String update(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateById(sysMenu);
        return ok("修改菜单成功");
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        sysMenuService.removeById(id);
        return ok("删除菜单成功");
    }
}
