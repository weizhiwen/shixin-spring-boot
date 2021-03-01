package com.shixin.dal.dao;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Assert;
import com.google.common.collect.Iterables;
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

import java.util.Arrays;
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
        TimeInterval timer = DateUtil.timer();
        List<D> insertList = repository.saveAll(list);
        log.info("插入数据花费" + timer.interval() + "毫秒");
        return insertList;
    }

    @Override
    public List<D> batchCreateAll(List<D> list) {
        Assert.notEmpty(list, "待创建对象列表不能为空");
        TimeInterval timer = DateUtil.timer();
        List<D> insertList = repository.insert(list);
        log.info("插入数据花费" + timer.interval() + "毫秒");
        return insertList;
    }

    @Override
    public List<D> batchCreateAll(List<D> list, int batchSize) {
        Iterable<List<D>> partitionList = Iterables.partition(list, batchSize);
        partitionList.forEach(this::batchCreateAll);
        return list;
    }

    @Override
    public D update(D d) {
        return update(d, true);
    }

    @Override
    public D update(D d, Boolean ignoreNull) {
        Assert.notNull(d, "待更新对象不能为空");
        Assert.notNull(d.getId(), "待更新对象Id不能为空");
        var toUpdate = repository.findById(d.getId()).orElse(null);
        Assert.notNull(toUpdate, "待更新对象列表不能为空");
        assert toUpdate != null;
        BeanUtil.copy(d, toUpdate, ignoreNull);
        return repository.save(toUpdate);
    }

    @Override
    public List<D> updateAll(List<D> list) {
        Assert.notEmpty(list, "待更新对象不能为空");
        return repository.saveAll(list);
    }

    @Override
    public long count(D d) {
        return repository.count(Example.of(d));
    }

    @Override
    public D findById(String id) {
        return repository.findById(id).filter(obj -> Objects.nonNull(obj.getDeleted()) && !obj.getDeleted())
                .orElse(null);
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
    public Page<D> pageQuery(D d, Pageable pageable) {
        return repository.findAll(Example.of(d), pageable);
    }

    @Override
    public void deleteById(String id) {
        Assert.notNull(id, "删除ID不能为空");
        var toDelete = repository.findById(id).orElse(null);
        if (Objects.nonNull(toDelete)) {
            toDelete.setDeleted(null);
            repository.save(toDelete);
        }
    }

    @Override
    public void deleteByIds(List<String> ids) {
        Assert.notEmpty(ids, "删除ID列表不能为空");
        Iterable<D> list = repository.findAllById(ids);
        list.forEach(item-> item.setDeleted(null));
        repository.saveAll(list);
    }

    @Override
    public void deleteByIds(String... ids) {
        deleteByIds(Arrays.asList(ids));
    }

    @Override
    public void delete(D d) {
        Assert.notNull(d.getId(), "删除ID不能为空");
        var toDelete = repository.findOne(Example.of(d)).orElse(null);
        if (Objects.nonNull(toDelete)) {
            toDelete.setDeleted(null);
            repository.save(toDelete);
        }
    }

    @Override
    public void physicalDeleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void physicalDelete(D d) {
        repository.delete(d);
    }
}
