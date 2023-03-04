package com.hw.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hw.demo.entity.SysMenu;
import com.hw.demo.entity.resp.SysMenuMeta;
import com.hw.demo.entity.resp.SysMenuResp;
import com.hw.demo.service.SysMenuService;
import com.hw.demo.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
* @author hanwei
* @description 针对表【sys_menu(系统菜单表)】的数据库操作Service实现
* @createDate 2023-03-02 20:06:32
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public List<SysMenuResp> getMenuList() {
        // 查询全部菜单列表并处理成前端需要的数据结构
        return toList(list());
    }

    private List<SysMenuResp> toList(List<SysMenu> list) {
        List<SysMenuResp> results = new ArrayList<>();
        for (SysMenu sysMenu : list) {
            if (sysMenu.getParentId() == 0) {
                SysMenuResp resp = toResp(sysMenu);
                // 递归处理
                resp.setChildren(getChildren(sysMenu, list));
                results.add(resp);
            }
        }
        return results;
    }

    private List<SysMenuResp> getChildren(SysMenu sysMenu, List<SysMenu> list) {
        List<SysMenuResp> children = new ArrayList<>();
        for (SysMenu menu : list) {
            if (Objects.equals(menu.getParentId(), sysMenu.getId())) {
                SysMenuResp child = toResp(menu);
                child.setChildren(getChildren(menu, list));
                children.add(child);
            }
        }
        return children;
    }

    private SysMenuResp toResp(SysMenu sysMenu) {
        SysMenuResp resp = new SysMenuResp();
        resp.setId(sysMenu.getId());
        resp.setParentId(sysMenu.getParentId());
        resp.setPath(sysMenu.getPath());
        resp.setName(sysMenu.getName());
        resp.setComponent(sysMenu.getComponent());
        resp.setMenuSort(sysMenu.getSort());
        resp.setIsLink(sysMenu.getIsLink() == 1);
        resp.setMenuType(sysMenu.getType() == 0 ? "menu" : "btn");
        resp.setRedirect(sysMenu.getRedirect());
        resp.setBtnPower("");
        resp.setMeta(toMeta(sysMenu));
        return resp;
    }

    private SysMenuMeta toMeta(SysMenu sysMenu) {
        SysMenuMeta meta = new SysMenuMeta();
        meta.setTitle(sysMenu.getTitle());
        meta.setIcon(sysMenu.getIcon());
        meta.setRoles(Arrays.stream(sysMenu.getRoles().split(",")).toList());
        meta.setIsAffix(sysMenu.getIsAffix() == 0);
        meta.setIsKeepAlive(sysMenu.getIsKeepAlive() == 0);
        meta.setIsHide(sysMenu.getIsHide() == 1);
        meta.setIsLink(sysMenu.getLink());
        meta.setIsIframe(sysMenu.getIsIframe() == 1);
        return meta;
    }
}




