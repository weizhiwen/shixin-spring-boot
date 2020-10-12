package com.shixin.framework.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import com.shixin.commons.util.BeanUtil;

import org.springframework.data.domain.Page;

import javax.validation.constraints.NotNull;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;

/**
 * 基础Service层接口，提供Service所需的转换方法，所有Service实现该接口
 * @author shixin
 * @date 2020/10/11 4:24 下午
 */
public interface BaseService {
    default <E, V> V convert(E e, @NotNull Class<V> clazz) {
        Assert.notNull(clazz);
        return null == e ? null : BeanUtil.copy(e, clazz);
    }

    default <E, V> List<V> convert(List<E> list, @NotNull Class<V> clazz) {
        Assert.notNull(clazz);
        if (CollectionUtil.isNotEmpty(list)) {
            return list.stream()
                    .map(e -> convert(e, clazz))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    default <E, V> Page<V> convert(@NotNull Page<E> page, @NotNull Class<V> clazz) {
        Assert.notNull(clazz);
        return page.map(e -> convert(e, clazz));
    }
}
