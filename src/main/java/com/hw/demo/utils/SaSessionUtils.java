package com.hw.demo.utils;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.hw.demo.entity.SysUser;

public class SaSessionUtils {

    private static final String CURRENT_USER_KEY = "current_user_key";

    public static void setCurrentUser(SysUser sysUser) {
        String json = JSON.toJSONString(sysUser, JSONWriter.Feature.WriteNulls, JSONWriter.Feature.BrowserCompatible);
        StpUtil.getSession().set(CURRENT_USER_KEY, json);
    }

    public static SysUser getCurrentUser() {
        String json = (String) StpUtil.getSession().get(CURRENT_USER_KEY);
        return JSON.parseObject(json, SysUser.class);
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

    public static boolean isSuper(SysUser sysUser) {
        return ObjectUtil.isNotNull(sysUser) && ObjectUtil.equal(sysUser.getType(), 0);
    }
}
