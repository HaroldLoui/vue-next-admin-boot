package com.hw.demo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hw.demo.entity.SysUser;
import com.hw.demo.entity.req.SysUserReq;
import com.hw.demo.exception.BusinessException;
import com.hw.demo.exception.PrimaryKeyNotNullException;
import com.hw.demo.service.SysUserService;
import com.hw.demo.mapper.SysUserMapper;
import com.hw.demo.utils.SaSessionUtils;
import com.hw.demo.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author hanwei
* @description 针对表【sys_user(系统用户表)】的数据库操作Service实现
* @createDate 2023-02-25 17:35:51
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    private static final String DEFAULT_PASSWORD = "123456";

    @Override
    public Page<SysUser> getPage(SysUserReq req) {
        req.setPageNum(ObjectUtil.defaultIfNull(req.getPageNum(), 1));
        req.setPageSize(ObjectUtil.defaultIfNull(req.getPageSize(), 10));
        return lambdaQuery()
                .like(StringUtils.isNotEmpty(req.getUsername()), SysUser::getUsername, req.getUsername())
                .like(StringUtils.isNotEmpty(req.getNickname()), SysUser::getNickname, req.getNickname())
                .like(StringUtils.isNotEmpty(req.getPhone()), SysUser::getPhone, req.getPhone())
                .like(StringUtils.isNotEmpty(req.getEmail()), SysUser::getEmail, req.getEmail())
                .eq(ObjectUtil.isNotNull(req.getStatus()), SysUser::getStatus, req.getStatus())
                .page(Page.of(req.getPageNum(), req.getPageSize()));
    }

    @Override
    public void saveUser(SysUser sysUser) {
        if (StringUtils.isEmpty(sysUser.getUsername())) {
            throw new BusinessException("用户名不能为空");
        }
        sysUser.setPassword(SecureUtil.md5(DEFAULT_PASSWORD).toUpperCase());
        sysUser.setCreateUser(SaSessionUtils.getCurrentUser().getId());
        save(sysUser);
    }

    @Override
    public void updateUser(SysUser sysUser) {
        if (ObjectUtil.isNull(sysUser.getId())) {
            throw new PrimaryKeyNotNullException("id不能为空");
        }
        sysUser.setUpdateUser(SaSessionUtils.getCurrentUser().getId());
        updateById(sysUser);
    }

    @Override
    public void updatePwd(SysUser sysUser) {
        if (ObjectUtil.isNull(sysUser.getId())) {
            throw new PrimaryKeyNotNullException("id不能为空");
        }
        if (StringUtils.isEmpty(sysUser.getPassword())) {
            throw new BusinessException("密码不能为空");
        }
        String newPassword = SecureUtil.md5(sysUser.getPassword()).toUpperCase();
        sysUser.setPassword(newPassword);
        SysUser currentUser = SaSessionUtils.getCurrentUser();
        sysUser.setUpdateUser(currentUser.getId());
        updateById(sysUser);
    }

    @Override
    public void deleteUser(Long id) {
        SysUser existUser = getById(id);
        if (existUser != null && existUser.getType() == 0) {
            throw new BusinessException("超级管理员账号无法删除");
        }
        removeById(id);
    }
}




