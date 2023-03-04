package com.hw.demo.mapper;

import com.hw.demo.entity.SysRolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hanwei
* @description 针对表【sys_role_permission(角色权限关联表)】的数据库操作Mapper
* @createDate 2023-03-01 19:33:27
* @Entity com.hw.demo.entity.SysRolePermission
*/
@Mapper
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {

}




