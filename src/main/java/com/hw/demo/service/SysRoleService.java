package com.hw.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hw.demo.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author hanwei
* @description 针对表【sys_role(系统角色表)】的数据库操作Service
* @createDate 2023-02-27 19:26:21
*/
public interface SysRoleService extends IService<SysRole> {

    Page<SysRole> getPage(int pageNum, int limit);
}
