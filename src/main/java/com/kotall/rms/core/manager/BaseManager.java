package com.kotall.rms.core.manager;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;

import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface BaseManager<T> {

    /**
     * 分页查询
     * @param query
     * @return
     */
    Page<T> queryByPage(Page<T> page, Query query);

    /**
     * 列表查询
     * @param query
     * @return
     */
    List<T> queryByList(Query query);

    /**
     * 保存
     * @param t
     * @return
     */
    boolean save(T t);

    /**
     * 根据ID获取
     * @param id
     * @return
     */
    T getById(Integer id);

    /**
     * 根据ID更新
     * @param t
     * @return
     */
    boolean updateById(T t);

    /**
     * 更新
     * @param t
     * @return
     */
    boolean update(T t);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 根据多个ID 批量删除
     * @param id
     * @return
     */
    boolean deleteByIds(Integer[] id);
}
