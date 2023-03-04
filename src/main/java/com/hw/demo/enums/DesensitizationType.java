package com.hw.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 脱敏类型
 */
@Getter
@AllArgsConstructor
public enum DesensitizationType {

    /**
     * 中文名
     */
    CHINESE_NAME,
    /**
     * 身份证号
     */
    ID_CARD,
    /**
     * 座机号
     */
    FIXED_PHONE,
    /**
     * 手机号
     */
    MOBILE_PHONE,
    /**
     * 地址
     */
    ADDRESS,
    /**
     * 电子邮件
     */
    EMAIL,
    /**
     * 银行卡
     */
    BANK_CARD,
    /**
     * 不做脱敏处理
     */
    NONE,
    ;

}