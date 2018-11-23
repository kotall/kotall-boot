package com.kotall.rms.core.service;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class BaseServiceImpl<M extends BaseManager<T>, T> implements BaseService<T> {

    @Autowired
    protected BaseManager<T> baseManager;

    @Override
    public Page<T> queryByPage(Map<String, Object> params) {
        Query query = new Query(params);
        Page<T> page = new Page<>(query);
        return this.baseManager.queryByPage(page, query);
    }

    @Override
    public List<T> queryByList(Map<String, Object> params) {
        Query query = new Query(params);
        return this.baseManager.queryByList(query);
    }

    @Override
    public boolean save(T t) {
        return this.baseManager.save(t);
    }

    @Override
    public T getById(Integer id) {
        return this.baseManager.getById(id);
    }

    @Override
    public boolean updateById(T t) {
        return this.baseManager.updateById(t);
    }

    @Override
    public boolean update(T t) {
        return this.baseManager.update(t);
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.baseManager.deleteById(id);
    }

    @Override
    public boolean deleteByIds(Integer[] id) {
        return this.baseManager.deleteByIds(id);
    }
}
