package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysDictEntity;

import java.util.List;

/**
 * 通用字典
 *
 * @author aracwong
 * @date 2017年8月15日 下午12:51:35
 */
public interface SysDictService {

	List<SysDictEntity> listDict();
	
	List<SysDictEntity> listNotMacro();
	
	int saveDict(SysDictEntity macro);

	SysDictEntity getObjectById(Long id);
	
	int updateDict(SysDictEntity macro);
	
	int batchRemove(Long[] id);
	
}
