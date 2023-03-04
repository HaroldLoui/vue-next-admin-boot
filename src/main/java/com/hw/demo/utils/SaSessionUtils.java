package com.hw.demo.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.hw.demo.entity.SysUser;

public class SaSessionUtils {

    private static final String CURRENT_USER_KEY = "current_user_key";

    public static void setCurrentUser(SysUser sysUser) {
        StpUtil.getSession().set(CURRENT_USER_KEY, sysUser);
    }

    public static SysUser getCurrentUser() {
        return (SysUser) StpUtil.getSession().get(CURRENT_USER_KEY);
    }

    public static void set(String key, Object val) {
        StpUtil.getSession().set(key, val);
    }

    public static Object get(String key) {
        return StpUtil.getSession().get(key);
    }

    public static void delete(String key) {
        StpUtil.getSession().delete(key);
    }

    public static void clear() {
        StpUtil.getSession().clear();
    }
}
