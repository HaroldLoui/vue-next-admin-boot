package com.hw.demo.entity.req;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SysUserReq implements Serializable {

    @Serial
    private static final long serialVersionUID = -6391645779304561451L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 0-正常 1-封禁 2-删除
     */
    private Integer status;

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 页面条数
     */
    private Integer pageSize;
}
