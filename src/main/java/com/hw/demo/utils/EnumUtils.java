package com.hw.demo.utils;

import cn.hutool.core.util.DesensitizedUtil;
import com.hw.demo.enums.DesensitizationType;

public class EnumUtils {

    /**
     * 将自定义数据脱敏枚举类型转换为Hutool工具类提供的数据脱敏枚举类型
     * @param type 自定义数据脱敏枚举类型
     * @return 数据脱敏枚举类型
     */
    public static DesensitizedUtil.DesensitizedType transCustomDesType2HuDesType(DesensitizationType type) {
        return switch (type) {
            case CHINESE_NAME -> DesensitizedUtil.DesensitizedType.CHINESE_NAME;
            case ID_CARD -> DesensitizedUtil.DesensitizedType.ID_CARD;
            case FIXED_PHONE -> DesensitizedUtil.DesensitizedType.FIXED_PHONE;
            case MOBILE_PHONE -> DesensitizedUtil.DesensitizedType.MOBILE_PHONE;
            case ADDRESS -> DesensitizedUtil.DesensitizedType.ADDRESS;
            case EMAIL -> DesensitizedUtil.DesensitizedType.EMAIL;
            case BANK_CARD -> DesensitizedUtil.DesensitizedType.BANK_CARD;
            default -> null;
        };
    }
}
