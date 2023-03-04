package com.hw.demo.filter;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.hw.demo.annotations.Desensitization;
import com.hw.demo.utils.EnumUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * 数据脱敏
 */
@Component
@Qualifier
public class DesensitizationFilter extends FastjsonFilter {

    @Override
    public Object apply(Object object, String name, Object value) {
        // TODO：如果是超级管理员查询则不需要进行数据脱敏
        Field field = ReflectUtil.getField(object.getClass(), name);
        Desensitization des = AnnotationUtil.getAnnotation(field, Desensitization.class);
        if (ObjectUtil.isNotNull(des)) {
            DesensitizedUtil.DesensitizedType type = EnumUtils.transCustomDesType2HuDesType(des.type());
            return DesensitizedUtil.desensitized(value.toString(), type);
        }
        return value;
    }
}
