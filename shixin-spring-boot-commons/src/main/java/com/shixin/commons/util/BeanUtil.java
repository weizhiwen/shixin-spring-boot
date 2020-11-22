package com.shixin.commons.util;

import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ReflectUtil;

/**
 * @author shixin
 * @date 2020/10/11 3:55 下午
 */
public final class BeanUtil {
    private static final CopyOptions OPTIONS = CopyOptions.create().ignoreNullValue().ignoreError().ignoreCase();

    public static void copy(Object source, Object target) {
        cn.hutool.core.bean.BeanUtil.copyProperties(source, target, OPTIONS);
    }

    public static <T> T copy(Object source, Class<T> clazz) {
        T target = ReflectUtil.newInstance(clazz);
        cn.hutool.core.bean.BeanUtil.copyProperties(source, target, OPTIONS);
        return target;
    }
}
