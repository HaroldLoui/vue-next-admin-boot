package com.hw.demo.entity.resp;

import com.hw.demo.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

/**
 * 构造成前端需要的数据结构
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
    private Integer type;

    /**
     * 路由名称
     */
    private String name;

    /**
     * 路由路径
     */
    private String path;

    /**
     * 重定向
     */
    private String redirect;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 基本信息
     */
    private SysMenuMeta meta;

    /**
     * 子菜单
     */
    private List<SysMenuResp> children;
}
