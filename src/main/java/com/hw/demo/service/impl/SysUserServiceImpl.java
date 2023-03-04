package com.hw.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hw.demo.entity.SysUser;
import com.hw.demo.service.SysUserService;
import com.hw.demo.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author hanwei
* @description 针对表【sys_user(系统用户表)】的数据库操作Service实现
* @createDate 2023-02-25 17:35:51
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




