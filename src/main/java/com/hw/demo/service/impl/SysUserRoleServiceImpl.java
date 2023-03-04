package com.hw.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hw.demo.entity.SysUserRole;
import com.hw.demo.service.SysUserRoleService;
import com.hw.demo.mapper.SysUserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author hanwei
* @description 针对表【sys_user_role(用户角色关联表)】的数据库操作Service实现
* @createDate 2023-03-01 19:32:42
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
    implements SysUserRoleService{

}




