package com.hw.demo.utils;

import cn.hutool.core.util.StrUtil;

/**
 * 基于Hutool.StrUtil二次封装字符串工具类
 */
public class StringUtils extends StrUtil {

    /**
     * 两字符串不相等（不忽略大小写）
     * @param str1
     * @param str2
     * @return
     */
    public static boolean notEquals(CharSequence str1, CharSequence str2) {
        return !equals(str1, str2);
    }

    /**
     * 两字符串不相等（忽略大小写）
     * @param str1
     * @param str2
     * @return
     */
    public static boolean notEqualsIgnoreCase(CharSequence str1, CharSequence str2) {
        return !equalsIgnoreCase(str1, str2);
    }
}
