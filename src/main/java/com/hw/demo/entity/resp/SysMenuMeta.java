package com.hw.demo.entity.resp;

import lombok.Data;

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
     * 链接地址
     */
    private String link;

    /**
     * 权限标识
     */
    private String roles;

    /**
     * 是否隐藏（0-不隐藏，1-隐藏）
     */
    private Boolean isHide;

    /**
     * 页面缓存（0-缓存，1-不缓存）
     */
    private Boolean isCache;

    /**
     * 是否固定（0-固定，1-不固定）
     */
    private Boolean isFixed;

    /**
     * 是否外链（0-否，1-是）
     */
    private Boolean isLink;

    /**
     * 是否内嵌（0-否，1-是）
     */
    private Boolean isIframe;

}
