package com.shixin.commons.util;

import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ReflectUtil;

/**
 * @author shixin
 * @date 2020/10/11 3:55 下午
 */
public final class BeanUtil {
    private static final CopyOptions OPTIONS_IGNORE_NULL = CopyOptions.create().ignoreNullValue().ignoreError().ignoreCase();
    private static final CopyOptions OPTIONS_WITH_NULL = CopyOptions.create().ignoreError().ignoreCase();

    public static void copy(Object source, Object target) {
        cn.hutool.core.bean.BeanUtil.copyProperties(source, target, OPTIONS_IGNORE_NULL);
    }

    public static void copy(Object source, Object target, Boolean ignoreNull) {
        if (!ignoreNull) {
            cn.hutool.core.bean.BeanUtil.copyProperties(source, target, OPTIONS_WITH_NULL);
        } else {
            copy(source, target);
        }
    }

    public static <T> T copy(Object source, Class<T> clazz) {
        T target = ReflectUtil.newInstance(clazz);
        cn.hutool.core.bean.BeanUtil.copyProperties(source, target, OPTIONS_IGNORE_NULL);
        return target;
    }

    public static <T> T copy(Object source, Class<T> clazz, Boolean ignoreNull) {
        if (!ignoreNull) {
            T target = ReflectUtil.newInstance(clazz);
            cn.hutool.core.bean.BeanUtil.copyProperties(source, target, OPTIONS_WITH_NULL);
            return target;
        } else {
            return copy(source, clazz);
        }
    }
}
