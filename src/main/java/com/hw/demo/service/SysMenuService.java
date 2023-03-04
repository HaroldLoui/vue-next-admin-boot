package com.hw.demo.service;

import com.hw.demo.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hw.demo.entity.resp.SysMenuResp;

import java.util.List;

/**
* @author hanwei
* @description 针对表【sys_menu(系统菜单表)】的数据库操作Service
* @createDate 2023-03-02 20:06:32
*/
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenuResp> getMenuList();
}
