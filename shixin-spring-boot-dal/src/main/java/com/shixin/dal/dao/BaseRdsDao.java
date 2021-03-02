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

    // 对应数据库的 insert 操作

    /**
     * 插入单个对象，生成一条数据
     *
     * @param t 对象
     * @return 创建的对象
     */
    T insert(T t);

    /**
     * 插入多个对象（一次插入一个对象），生成多条数据（一次生成一条数据）
     *
     * @param list 对象列表
     * @return 创建的对象列表
     */
    List<T> multiInsert(List<T> list);

    /**
     * 批量插入对象（一次提交多个对象）默认1000条数据提交一次，生成多条数据（一次生成多条数据）
     *
     * @param list 对象列表
     * @return 创建的对象列表
     */
    List<T> batchInsert(List<T> list);

    /**
     * 批量插入对象（一次提交多个对象），自定义多少条提交一次，生成多条数据（一次生成多条数据）
     *
     * @param list 对象列表
     * @return 创建的对象列表
     */
    List<T> batchInsert(List<T> list, int batchSize);

    /**
     * 批量插入对象（一次提交多个对象），自定义多少条提交一次，生成多条数据（一次生成多条数据）
     *
     * @param list 对象列表
     * @return 创建的对象列表
     */
    List<T> batchInsert(List<T> list, long batchSize);

    // 对应数据库的 update 操作

    /**
     * 更新对象，默认忽略Null值更新
     *
     * @param t 待更新对象
     * @return 更新后的对象
     */
    T update(T t);

    /**
     * 根据id更新对象，可以设置Null值是否更新
     *
     * @param t          待更新对象
     * @param ignoreNull 更新时是否忽略null值
     * @return 更新后的对象
     */
    T update(T t, Boolean ignoreNull);

    /**
     * 更新所有对象，可以设置Null值是否更新
     *
     * @param list 待更新对象列表
     * @return 更新后的对象
     */
    List<T> multiUpdate(List<T> list);

    /**
     * 根据查询对象统计数量
     */
    long count(T t);

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
     * 分页查询
     *
     * @param t        查询对象
     * @param pageable 分页对象
     * @return 分页结果
     */
    Page<T> pageQuery(T t, Pageable pageable);

    /**
     * 根据id删除对象 默认逻辑删除
     *
     * @param id 对象Id
     */
    void deleteById(Integer id);

    /**
     * 根据id删除对象 默认逻辑删除
     *
     * @param ids 对象Id列表
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据id删除对象 默认逻辑删除
     *
     * @param ids 对象Id列表
     */
    void deleteByIds(Integer... ids);

    /**
     * 根据对象删除对象 默认逻辑删除
     *
     * @param t 查询对象
     */
    void delete(T t);

}
