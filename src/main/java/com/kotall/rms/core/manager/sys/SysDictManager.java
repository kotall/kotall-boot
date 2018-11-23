package com.kotall.rms.core.manager.sys;

import java.util.List;

import com.kotall.rms.common.entity.sys.SysDictEntity;
import com.kotall.rms.core.manager.BaseManager;


/**
 * 通用字典
 *
 * @author aracwong
 * @date 2017年8月15日 下午12:49:14
 */
public interface SysDictManager extends BaseManager<SysDictEntity> {

	List<SysDictEntity> listDict();

	List<SysDictEntity> listNotDict();
	
	boolean hasChildren(Integer[] id);
	
}
