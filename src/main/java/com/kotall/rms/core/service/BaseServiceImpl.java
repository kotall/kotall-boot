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
    protected M manager;

    @Override
    public Page<T> queryByPage(Map<String, Object> params) {
        Query query = new Query(params);
        Page<T> page = new Page<>(query);
        return this.manager.queryByPage(page, query);
    }

    @Override
    public List<T> queryByList(Map<String, Object> params) {
        Query query = new Query(params);
        return this.manager.queryByList(query);
    }

    @Override
    public boolean save(T t) {
        return this.manager.save(t);
    }

    @Override
    public T getById(Integer id) {
        return this.manager.getById(id);
    }

    @Override
    public boolean updateById(T t) {
        return this.manager.updateById(t);
    }

    @Override
    public boolean update(T t) {
        return this.manager.update(t);
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.manager.deleteById(id);
    }

    @Override
    public boolean deleteByIds(Integer[] id) {
        return this.manager.deleteByIds(id);
    }
}
