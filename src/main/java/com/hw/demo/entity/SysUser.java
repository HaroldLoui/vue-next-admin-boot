package com.hw.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import jakarta.validation.constraints.NotEmpty;

import com.hw.demo.annotations.Desensitization;
import com.hw.demo.common.BaseEntity;
import com.hw.demo.enums.DesensitizationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户表
 * @TableName sys_user
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_user")
@Data
public class SysUser extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 2248148249999078833L;

    /**
     * 系统用户id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    @Desensitization(type = DesensitizationType.MOBILE_PHONE)
    private String phone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @Desensitization(type = DesensitizationType.EMAIL)
    private String email;

    /**
     * 1-正常 0-封禁
     */
    @TableField(value = "status")
    private Boolean status;

    /**
     * 账号类型：0-超级管理员、1-普通管理员、2-普通用户
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;
}