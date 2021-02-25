package com.shixin.dal.dao;


import com.shixin.dal.entity.BaseDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * MongoDB数据库 Dao层基础接口
 *
 * @param <D> 实体类
 * @author shixin
 * @date 2020/12/5
 */
public interface BaseMongoDao<D extends BaseDocument> {

    /**
     * 创建对象
     *
     * @param d 对象
     * @return 创建的对象
     */
    D create(D d);

    /**
     * 批量创建对象
     *
     * @param list 对象列表
     * @return 创建的对象列表
     */
    List<D> createAll(List<D> list);

    /**
     * 根据id更新对象，默认忽略Null值更新
     *
     * @param d 待更新对象
     * @return 更新后的对象
     */
    D update(D d);

    /**
     * 根据id更新对象，可以设置Null值是否更新
     *
     * @param d 待更新对象
     * @return 更新后的对象
     */
    D update(D d, Boolean ignoreNull);

    /**
     * 根据id查找对象
     *
     * @param id 对象Id
     * @return 对象或Null
     */
    D findById(String id);

    /**
     * 根据查询对象查找对象
     *
     * @param d 查询对象
     * @return 对象
     */
    D findOne(D d);

    /**
     * 根据查询对象查找对象
     *
     * @return 所有对象列表
     */
    List<D> findAll();

    /**
     * 根据查询对象查找对象
     *
     * @param d 查询对象
     * @return 对象列表
     */
    List<D> findAll(D d);

    /**
     * 分页查询
     *
     * @param d        查询对象
     * @param sort     排序对象
     * @return 分页结果
     */
    List<D> findAll(D d, Sort sort);

    /**
     * 根据id删除对象 默认逻辑删除
     *
     * @param id 对象Id
     */
    void deleteById(String id);

    /**
     * 根据对象删除对象 默认逻辑删除
     *
     * @param d 查询对象
     */
    void delete(D d);

    /**
     * 分页查询
     *
     * @param d        查询对象
     * @param pageable 分页对象
     * @return 分页结果
     */
    Page<D> pageQuery(D d, Pageable pageable);
}
