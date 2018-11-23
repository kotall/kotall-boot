package com.kotall.rms.core.service;

import com.kotall.rms.common.dao.sys.BaseMapper;
import com.kotall.rms.common.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> implements BaseService<T> {

    @Autowired
    protected BaseMapper<T> baseMapper;

    @Override
    public Page<T> queryByPage(Map<String, Object> params) {
        return null;
    }

    @Override
    public List<T> queryByList(Map<String, Object> params) {
        return null;
    }

    @Override
    public boolean save(T t) {
        return false;
    }

    @Override
    public T getById(Integer id) {
        return null;
    }

    @Override
    public boolean updateById(Integer id) {
        return false;
    }

    @Override
    public boolean update(T t) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public boolean deleteByIds(Integer[] id) {
        return false;
    }
}
