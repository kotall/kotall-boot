package com.kotall.rms.common.dao;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;

/**
 * 基础dao
 *
 * @author aracwong
 * @date 2017年8月12日 下午12:23:18
 */
public interface BaseMapper<T> {
	
	/**
	 * 新增
	 * @param t
	 * @return
	 */
	int insert(T t);
	
	/**
	 * 新增
	 * @param query
	 * @return
	 */
	int insert(Query query);
	
	/**
	 * 批量新增
	 * @param items
	 * @return
	 */
	int batchInsert(List<T> items);
	
	/**
	 * 查询详情
	 * @param query
	 * @return
	 */
	T findOne(Query query);
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	T getById(Object id);

	/**
	 * 根据ID更新
	 * @param t
	 * @return
	 */
	int updateById(T t);

	/**
	 * 根据条件更新
	 * @param t
	 * @return
	 */
	int update(T t);
	
	/**
	 * 根据条件更新
	 * @param query
	 * @return
	 */
	int update(Query query);
	
	/**
	 * 批量更新
	 * @param query
	 * @return
	 */
	int batchUpdate(Query query);


	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	int deleteById(Object id);

	/**
	 * 删除
	 * @param query
	 * @return
	 */
	int delete(Query query);
	

	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	int batchDelete(Object[] id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	List<T> list(Query query);

	/**
	 * 分页查询列表
	 * @param query
	 * @param page
	 * @return
	 */
	List<T> list(Query query, Page<T> page);

	/**
	 * 统计
	 * @param query
	 * @return
	 */
	int countTotal(Query query);

}
