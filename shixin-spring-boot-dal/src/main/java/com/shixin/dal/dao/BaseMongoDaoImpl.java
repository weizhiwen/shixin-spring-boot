package com.shixin.dal.dao;

import cn.hutool.core.lang.Assert;
import com.shixin.commons.util.BeanUtil;
import com.shixin.dal.entity.BaseDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Dao层基础接口实现类
 *
 * @author weizhiwen
 * @date 2020/12/5
 */
@NoRepositoryBean
@Slf4j
public abstract class BaseMongoDaoImpl<R extends MongoRepository<D, String>, D extends BaseDocument> implements BaseMongoDao<D> {

    @Autowired
    protected R repository;

    @Override
    public D create(D d) {
        Assert.notNull(d, "待创建的对象不能为空");
        Assert.isNull(d.getId(), "待创建的对象Id必须为空");
        return repository.insert(d);
    }

    @Override
    public List<D> createAll(List<D> list) {
        Assert.notEmpty(list, "待创建对象列表不能为空");
        return repository.insert(list);
    }

    @Override
    public D update(D d) {
        return update(d, true);
    }

    @Override
    public D update(D d, Boolean ignoreNull) {
        Assert.notNull(d, "待更新对象{}不能为空");
        Assert.notNull(d.getId(), "待更新对象Id不能为空");
        var toUpdate = repository.findById(d.getId()).orElse(null);
        Assert.notNull(toUpdate, "待更新对象列表不能为空");
        BeanUtil.copy(d, toUpdate, ignoreNull);
        return repository.save(toUpdate);
    }

    @Override
    public D findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public D findOne(D d) {
        return repository.findOne(Example.of(d)).orElse(null);
    }

    @Override
    public List<D> findAll() {
        return repository.findAll();
    }

    @Override
    public List<D> findAll(D d) {
        return repository.findAll(Example.of(d));
    }

    @Override
    public List<D> findAll(D d, Sort sort) {
        return repository.findAll(Example.of(d), sort);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(D d) {
        repository.delete(d);
    }

    @Override
    public Page<D> pageQuery(D d, Pageable pageable) {
        return repository.findAll(Example.of(d), pageable);
    }
}
