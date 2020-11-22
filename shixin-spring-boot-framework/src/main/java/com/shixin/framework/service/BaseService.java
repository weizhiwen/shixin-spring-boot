package com.shixin.framework.service;

import com.shixin.commons.util.BeanUtil;

import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;

/**
 * 基础Service层接口，提供Service所需的转换方法，所有Service实现该接口
 *
 * @author shixin
 * @date 2020/10/11 4:24 下午
 */
public interface BaseService {
    /**
     * 转换方法，实体类对象转另一实体类对象
     *
     * @param e     源实体类对象
     * @param clazz 目标实体类
     * @return 目标实体类对象
     */
    default <E, V> V convert(E e, @NotNull Class<V> clazz) {
        Assert.notNull(clazz);
        return null == e ? null : BeanUtil.copy(e, clazz);
    }

    /**
     * 转换方法，实体类列表对象转另一实体类列表对象
     *
     * @param list  源列表
     * @param clazz 目标列表实体类
     * @return 目标实体类列表
     */
    default <E, V> List<V> convert(List<E> list, @NotNull Class<V> clazz) {
        Assert.notNull(clazz);
        if (CollectionUtil.isNotEmpty(list)) {
            return list.stream()
                    .map(e -> convert(e, clazz))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    /**
     * 转换方法，实体类的JPA分页对象转另一实体类JPA分页对象
     *
     * @param page  源实体类的JPA分页对象
     * @param clazz 目标分页对象实体类
     * @return 目标实体类分页对象
     */
    default <E, V> Page<V> convert(@NotNull Page<E> page, @NotNull Class<V> clazz) {
        Assert.notNull(clazz);
        return page.map(e -> convert(e, clazz));
    }
}
