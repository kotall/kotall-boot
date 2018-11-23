package com.kotall.rms.core.service;

import com.kotall.rms.common.utils.Page;

import java.util.List;
import java.util.Map;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface BaseService<T> {

    /**
     * 分页查询
     * @param params
     * @return
     */
    Page<T> queryByPage(Map<String, Object> params);

    /**
     * 列表查询
     * @param params
     * @return
     */
    List<T> queryByList(Map<String, Object> params);

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
     * @param id
     * @return
     */
    boolean updateById(Integer id);
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
