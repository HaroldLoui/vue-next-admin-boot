package com.hw.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hw.demo.common.BaseEntity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统菜单表
 * @TableName sys_menu
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_menu")
@Data
public class SysMenu extends BaseEntity implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 父级菜单id
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 菜单名称
     */
    @TableField(value = "title")
    @NotEmpty(message = "菜单名称不能为空")
    private String title;

    /**
     * 菜单类型（0-菜单，1-按钮）
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 路由名称
     */
    @TableField(value = "name")
    @NotEmpty(message = "路由名称不能为空")
    private String name;

    /**
     * 路由路径
     */
    @TableField(value = "path")
    @NotEmpty(message = "路由路径不能为空")
    private String path;

    /**
     * 重定向
     */
    @TableField(value = "redirect")
    private String redirect;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 组件路径
     */
    @TableField(value = "component")
    @NotEmpty(message = "组件路径不能为空")
    private String component;

    /**
     * 链接地址
     */
    @TableField(value = "link")
    private String link;

    /**
     * 权限标识
     */
    @TableField(value = "roles")
    private String roles;

    /**
     * 菜单排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 是否隐藏
     */
    @TableField(value = "is_hide")
    private Boolean isHide;

    /**
     * 页面缓存
     */
    @TableField(value = "is_keep_alive")
    private Boolean isKeepAlive;

    /**
     * 是否固定
     */
    @TableField(value = "is_affix")
    private Boolean isAffix;

    /**
     * 是否外链
     */
    @TableField(value = "is_link")
    private Boolean isLink;

    /**
     * 是否内嵌
     */
    @TableField(value = "is_iframe")
    private Boolean isIframe;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}