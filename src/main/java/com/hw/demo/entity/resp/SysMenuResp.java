package com.hw.demo.entity.resp;

import com.hw.demo.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

/**
 * 前端需要的数据结构
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenuResp extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -2589109649092806665L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 父级菜单id
     */
    private Long parentId;

    /**
     * 菜单类型（0-菜单，1-按钮）
     */
    private String menuType;

    /**
     * 路由名称
     */
    private String name;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 是否外链
     */
    private Boolean isLink;

    /**
     * 路由路径
     */
    private String path;

    /**
     * 重定向
     */
    private String redirect;

    /**
     * 菜单排序
     */
    private Integer menuSort;

    /**
     * 基本信息
     */
    private SysMenuMeta meta;

    /**
     * 菜单类型为按钮时，权限标识
     */
    private String btnPower;

    /**
     * 父级组件路径
     */
    private List<String>  menuSuperior;

    /**
     * 子菜单
     */
    private List<SysMenuResp> children;
}
