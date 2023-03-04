package com.hw.demo.mapper;

import com.hw.demo.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hanwei
* @description 针对表【sys_permission(系统权限表)】的数据库操作Mapper
* @createDate 2023-02-27 19:26:29
* @Entity com.hw.demo.entity.SysPermission
*/
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

}




