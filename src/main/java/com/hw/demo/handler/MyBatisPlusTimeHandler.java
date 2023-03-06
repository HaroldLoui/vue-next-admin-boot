package com.hw.demo.handler;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.hw.demo.utils.SaSessionUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Mybatis-plus自动填充创建人/时间和更新人/时间
 */
@Component
public class MyBatisPlusTimeHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (StpUtil.isLogin()) {
            this.strictInsertFill(metaObject, "createUser", Long.class, SaSessionUtils.getCurrentUser().getId());
        }
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        if (StpUtil.isLogin()) {
            this.strictUpdateFill(metaObject, "updateUser", Long.class, SaSessionUtils.getCurrentUser().getId());
        }
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
