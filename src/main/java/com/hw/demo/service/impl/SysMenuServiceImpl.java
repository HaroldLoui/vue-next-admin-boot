package com.hw.demo.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hw.demo.entity.SysMenu;
import com.hw.demo.entity.resp.SysMenuMeta;
import com.hw.demo.entity.resp.SysMenuResp;
import com.hw.demo.exception.BusinessException;
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

    @Override
    public void deleteMenu(Long id) {
        // 检查id是否存在
        SysMenu sysMenu = getById(id);
        if (sysMenu == null) {
            // 若不存在则直接返回
            return;
        }
        // 查询子菜单
        List<SysMenu> children = lambdaQuery().eq(SysMenu::getParentId, id).list();
        if (CollectionUtil.isNotEmpty(children)) {
            throw new BusinessException("该菜单存在子菜单，无法删除");
        }
        // 删除
        removeById(id);
    }

    @Override
    public void deleteMenuForce(Long id) {
        // 检查id是否存在
        SysMenu sysMenu = getById(id);
        if (sysMenu == null) {
            // 若不存在则直接返回
            return;
        }
        // 查询子菜单
        List<SysMenu> children = lambdaQuery().eq(SysMenu::getParentId, id).list();
        if (CollectionUtil.isNotEmpty(children)) {
            List<Long> idList = toList(children).stream().map(SysMenuResp::getId).toList();
            // 批量删除所有子菜单
            removeBatchByIds(idList, idList.size());
        }
        // 删除自身
        removeById(id);
    }

    /**
     * 获取最顶级的菜单列表
     */
    private List<SysMenuResp> toList(List<SysMenu> list) {
        List<SysMenuResp> results = new ArrayList<>();
        for (SysMenu sysMenu : list) {
            if (sysMenu.getParentId() == 0) {
                SysMenuResp resp = toResp(sysMenu);
                // 递归处理
                resp.setChildren(getChildren(resp, list));
                results.add(resp);
            }
        }
        return results;
    }

    /**
     * 递归在<code>list</code>中获取<code>resp</code>的子菜单
     */
    private List<SysMenuResp> getChildren(SysMenuResp resp, List<SysMenu> list) {
        List<SysMenuResp> children = new ArrayList<>();
        for (SysMenu menu : list) {
            if (Objects.equals(menu.getParentId(), resp.getId())) {
                SysMenuResp child = toResp(menu);
                List<String> menuSuperior = new ArrayList<>(ObjectUtil.defaultIfNull(resp.getMenuSuperior(), new ArrayList<>()));
                menuSuperior.add(resp.getId().toString());
                child.setMenuSuperior(menuSuperior);
                child.setChildren(getChildren(child, list));
                children.add(child);
            }
        }
        return children;
    }

    /**
     * 构造成前端需要的数据结构
     */
    private SysMenuResp toResp(SysMenu sysMenu) {
        SysMenuResp resp = new SysMenuResp();
        resp.setId(sysMenu.getId());
        resp.setParentId(sysMenu.getParentId());
        resp.setPath(sysMenu.getPath());
        resp.setName(sysMenu.getName());
        resp.setComponent(sysMenu.getComponent());
        resp.setMenuSort(sysMenu.getSort());
        resp.setIsLink(sysMenu.getIsLink());
        resp.setMenuType(sysMenu.getType() == 0 ? "menu" : "btn");
        resp.setRedirect(sysMenu.getRedirect());
        resp.setBtnPower("");
        resp.setMeta(toMeta(sysMenu));
        return resp;
    }

    /**
     * 转成Meta
     */
    private SysMenuMeta toMeta(SysMenu sysMenu) {
        SysMenuMeta meta = new SysMenuMeta();
        meta.setTitle(sysMenu.getTitle());
        meta.setIcon(sysMenu.getIcon());
        meta.setRoles(Arrays.stream(sysMenu.getRoles().split(",")).toList());
        meta.setIsAffix(sysMenu.getIsAffix());
        meta.setIsKeepAlive(sysMenu.getIsKeepAlive());
        meta.setIsHide(sysMenu.getIsHide());
        meta.setIsLink(sysMenu.getLink());
        meta.setIsIframe(sysMenu.getIsIframe());
        return meta;
    }
}




