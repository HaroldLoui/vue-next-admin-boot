package com.hw.demo.entity.resp;

import lombok.Data;

import java.util.List;

@Data
public class SysMenuMeta {

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 权限标识
     */
    private List<String> roles;

    /**
     * 是否隐藏（0-不隐藏，1-隐藏）
     */
    private Boolean isHide;

    /**
     * 页面缓存（0-缓存，1-不缓存）
     */
    private Boolean isKeepAlive;

    /**
     * 是否固定（0-固定，1-不固定）
     */
    private Boolean isAffix;

    /**
     * 是否外链（0-否，1-是）
     */
    private String isLink;

    /**
     * 是否内嵌（0-否，1-是）
     */
    private Boolean isIframe;

}
