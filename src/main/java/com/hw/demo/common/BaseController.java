package com.hw.demo.common;

import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.hw.demo.filter.FastjsonFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class BaseController {

    /**
     * 自定义的Fastjson拦截器
     */
    @Qualifier
    @Autowired
    private List<FastjsonFilter> filters;

    /**
     * 详情见：<a href="https://gitee.com/wenshao/fastjson2/blob/main/docs/features_cn.md#5-jsonwriterfeature%E4%BB%8B%E7%BB%8D">link</a>
     */
    private static final JSONWriter.Feature[] FEATURES = {
            JSONWriter.Feature.WriteNulls,
            JSONWriter.Feature.BrowserCompatible,
            JSONWriter.Feature.WriteNullListAsEmpty
    };

    protected String ok(String msg) {
        return JSON.toJSONString(Result.ok(msg));
    }

    protected <T> String ok(String msg, T data) {
        return JSON.toJSONString(Result.ok(msg, data), ArrayUtil.toArray(filters, FastjsonFilter.class), FEATURES);
    }

    protected <T> String ok(int code, String msg, T data) {
        return JSON.toJSONString(Result.ok(code, msg, data), ArrayUtil.toArray(filters, FastjsonFilter.class), FEATURES);
    }

    protected String fail(String msg) {
        return JSON.toJSONString(Result.fail(msg));
    }

    protected <T> String fail(String msg, T data) {
        return JSON.toJSONString(Result.fail(msg, data), ArrayUtil.toArray(filters, FastjsonFilter.class), FEATURES);
    }

    protected <T> String fail(int code, String msg, T data) {
        return JSON.toJSONString(Result.fail(code, msg, data), ArrayUtil.toArray(filters, FastjsonFilter.class), FEATURES);
    }
}
