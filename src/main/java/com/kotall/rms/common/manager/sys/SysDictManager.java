package com.kotall.rms.common.manager.sys;

import java.util.List;

import com.kotall.rms.common.entity.sys.SysDictEntity;


/**
 * 通用字典
 *
 * @author aracwong
 * @date 2017年8月15日 下午12:49:14
 */
public interface SysDictManager {

	List<SysDictEntity> listMacro();
	
	List<SysDictEntity> listNotMacro();
	
	int saveMacro(SysDictEntity macro);
	
	SysDictEntity getObjectById(Long id);
	
	int updateMacro(SysDictEntity macro);
	
	int batchRemove(Long[] id);
	
	boolean hasChildren(Long[] id);
	
}
