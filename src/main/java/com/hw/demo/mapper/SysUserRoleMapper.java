package com.hw.demo.mapper;

import com.hw.demo.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hanwei
* @description 针对表【sys_user_role(用户角色关联表)】的数据库操作Mapper
* @createDate 2023-03-01 19:32:42
* @Entity com.hw.demo.entity.SysUserRole
*/
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}




