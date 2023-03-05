package com.hw.demo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.hutool.core.util.ObjectUtil;
import com.hw.demo.common.BaseController;
import com.hw.demo.entity.SysMenu;
import com.hw.demo.entity.resp.SysMenuResp;
import com.hw.demo.exception.PrimaryKeyNotNullException;
import com.hw.demo.service.SysMenuService;
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

import java.util.List;

@SaCheckLogin
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 查询菜单列表
     */
    @GetMapping("/list")
    public String getMenuList() {
        List<SysMenuResp> results = sysMenuService.getMenuList();
        return ok("查询菜单列表成功", results);
    }

    /**
     * 新增菜单
     */
    @PostMapping("/save")
    public String save(@RequestBody @Validated SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return ok("新增菜单成功");
    }

    /**
     * 修改菜单
     */
    @PutMapping("/update")
    public String update(@RequestBody @Validated SysMenu sysMenu) {
        if (ObjectUtil.isNull(sysMenu.getId())) {
            throw new PrimaryKeyNotNullException();
        }
        sysMenuService.updateById(sysMenu);
        return ok("修改菜单成功");
    }

    /**
     * 删除当前菜单（若存在子菜单则无法删除）
     */
    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        sysMenuService.deleteMenu(id);
        return ok("删除菜单成功");
    }

    /**
     * 强制删除当前菜单（递归删除所有存在的子菜单）
     */
    @DeleteMapping("/deleteForce")
    public String deleteForce(@RequestParam Long id) {
        sysMenuService.deleteMenuForce(id);
        return ok("删除菜单成功");
    }
}
