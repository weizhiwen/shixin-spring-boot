package com.shixin.dal.dao;


import com.shixin.dal.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 关系型数据库 Dao层基础接口
 *
 * @param <T> 实体类
 * @author shixin
 * @date 2020/12/5
 */
public interface BaseRdsDao<T extends BaseEntity> {

    /**
     * 创建对象
     *
     * @param t 对象
     * @return 创建的对象
     */
    T create(T t);

    /**
     * 批量创建对象
     *
     * @param list 对象列表
     * @return 创建的对象列表
     */
    List<T> createAll(List<T> list);

    /**
     * 根据id更新对象，默认忽略Null值更新
     *
     * @param t 待更新对象
     * @return 更新后的对象
     */
    T update(T t);

    /**
     * 根据id更新对象，可以设置Null值是否更新
     *
     * @param t          待更新对象
     * @param ignoreNull
     * @return 更新后的对象
     */
    T update(T t, Boolean ignoreNull);

    /**
     * 根据id查找对象
     *
     * @param id 对象Id
     * @return 对象或Null
     */
    T findById(Integer id);

    /**
     * 根据查询对象查找对象
     *
     * @param t 查询对象
     * @return 对象
     */
    T findOne(T t);

    /**
     * 根据查询对象查找对象
     *
     * @param t 查询对象
     * @return 对象列表
     */
    List<T> findAll(T t);

    /**
     * 根据查询对象查找对象
     *
     * @return 所有对象列表
     */
    List<T> findAll();

    /**
     * 根据id删除对象 默认逻辑删除
     *
     * @param id 对象Id
     */
    void deleteById(Integer id);

    /**
     * 根据对象删除对象 默认逻辑删除
     *
     * @param t 查询对象
     */
    void delete(T t);

    /**
     * 分页查询
     *
     * @param t        查询对象
     * @param pageable 分页对象
     * @return 分页结果
     */
    Page<T> pageQuery(T t, Pageable pageable);
}
