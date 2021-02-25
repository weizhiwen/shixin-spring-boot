package com.shixin.dal.dao;

import cn.hutool.core.lang.Assert;
import com.shixin.commons.util.BeanUtil;
import com.shixin.dal.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Objects;

/**
 * Dao层基础接口实现类
 *
 * @author weizhiwen
 * @date 2020/12/5
 */
@NoRepositoryBean
@Slf4j
public abstract class BaseRdsDaoImpl<R extends JpaRepository<T, Integer>, T extends BaseEntity> implements BaseRdsDao<T> {

    @Autowired
    protected R repository;

    @Override
    public T create(T t) {
        Assert.notNull(t, "待创建的对象不能为空");
        Assert.isNull(t.getId(), "待创建的对象Id必须为空");
        return repository.saveAndFlush(t);
    }

    @Override
    public List<T> createAll(List<T> list) {
        Assert.notEmpty(list, "待创建对象列表不能为空");
        return repository.saveAll(list);
    }

    @Override
    public T update(T t) {
        Assert.notNull(t, "待更新对象{}不能为空");
        Assert.notNull(t.getId(), "待更新对象Id不能为空");
        var toUpdate = repository.getOne(t.getId());
        BeanUtil.copy(t, toUpdate);
        return repository.save(toUpdate);
    }

    @Override
    public T update(T t, Boolean ignoreNull) {
        Assert.notNull(t, "待更新对象{}不能为空");
        Assert.notNull(t.getId(), "待更新对象Id不能为空");
        var toUpdate = repository.getOne(t.getId());
        BeanUtil.copy(t, toUpdate, ignoreNull);
        return repository.save(toUpdate);
    }


    @Override
    public T findById(Integer id) {
        Assert.notNull(id, "查询Id不能为空");
        return repository.findById(id).filter(obj -> Objects.nonNull(obj.getDeleted()) && !obj.getDeleted())
                .orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        Assert.notNull(id, "删除Id不能为空");
        var toDelete = repository.getOne(id);
        toDelete.setDeleted(null);
        repository.save(toDelete);
    }

    @Override
    public void delete(T t) {
        Assert.notNull(t.getId(), "删除ID不能为空");
        var toDelete = this.findOne(t);
        Assert.notNull(toDelete, "删除对象不存在");
        toDelete.setDeleted(null);
        repository.save(toDelete);
    }

    @Override
    public Page<T> pageQuery(T t, Pageable pageable) {
        return repository.findAll(Example.of(t), pageable);
    }

    @Override
    public T findOne(T t) {
        return repository.findOne(Example.of(t)).orElse(null);
    }

    @Override
    public List<T> findAll(T t) {
        return repository.findAll(Example.of(t));
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
