package com.hw.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hw.demo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hw.demo.entity.req.SysUserReq;

/**
* @author hanwei
* @description 针对表【sys_user(系统用户表)】的数据库操作Service
* @createDate 2023-02-25 17:35:51
*/
public interface SysUserService extends IService<SysUser> {

    Page<SysUser> getPage(SysUserReq req);

    void saveUser(SysUser sysUser);

    void updateUser(SysUser sysUser);

    void updatePwd(SysUser sysUser);

    void deleteUser(Long id);
}
