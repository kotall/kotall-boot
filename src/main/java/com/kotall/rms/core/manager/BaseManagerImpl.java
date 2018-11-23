package com.kotall.rms.core.manager;

import com.kotall.rms.common.dao.sys.BaseMapper;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class BaseManagerImpl<M extends BaseMapper<T>, T> implements BaseManager<T> {

    @Autowired
    protected M mapper;

    @Override
    public Page<T> queryByPage(Page<T> page, Query query) {
        List<T> rows = this.mapper.listForPage(page, query);
        page.setRows(rows);
        return page;
    }

    @Override
    public List<T> queryByList(Query query) {
        return this.mapper.list(query);
    }

    @Override
    public boolean save(T t) {
        return this.mapper.save(t) == 1;
    }

    @Override
    public T getById(Integer id) {
        return this.mapper.getObjectById(id);
    }

    @Override
    public boolean updateById(T t) {
        return this.mapper.updateById(t) == 1;
    }

    @Override
    public boolean update(T t) {
        return this.mapper.update(t) == 1;
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.mapper.remove(id) == 1;
    }

    @Override
    public boolean deleteByIds(Integer[] ids) {
        return this.mapper.batchRemove(ids) == ids.length;
    }
}
