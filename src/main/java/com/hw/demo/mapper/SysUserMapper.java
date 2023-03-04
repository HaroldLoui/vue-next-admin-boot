package com.hw.demo.mapper;

import com.hw.demo.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hanwei
* @description 针对表【sys_user(系统用户表)】的数据库操作Mapper
* @createDate 2023-02-25 17:35:51
* @Entity com.hw.demo.entity.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}




