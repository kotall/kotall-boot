package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysDictEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.List;

/**
 * 通用字典
 *
 * @author aracwong
 * @date 2017年8月15日 下午12:51:35
 */
public interface SysDictService extends BaseService<SysDictEntity> {

	List<SysDictEntity> listDict();
	
	List<SysDictEntity> listNotDict();

	boolean removeByIds(Integer[] id);
	
}
