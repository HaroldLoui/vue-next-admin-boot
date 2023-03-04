package com.hw.demo.mapper;

import com.hw.demo.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hanwei
* @description 针对表【sys_role(系统角色表)】的数据库操作Mapper
* @createDate 2023-02-27 19:26:21
* @Entity com.hw.demo.entity.SysRole
*/
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

}




