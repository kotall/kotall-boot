package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysDictMapper;
import com.kotall.rms.common.entity.sys.SysDictEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.sys.SysDictManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 通用字典
 *
 * @author aracwong
 * @date 2017年8月15日 下午12:49:26
 */
@Component("sysDictManager")
public class SysDictManagerImpl extends BaseManagerImpl<SysDictMapper, SysDictEntity> implements SysDictManager {

	@Autowired
	private SysDictMapper sysDictMapper;
	
	@Override
	public List<SysDictEntity> listDict() {
		return sysDictMapper.list(new Query());
	}

	@Override
	public List<SysDictEntity> listNotDict() {
		return sysDictMapper.listNotDict();
	}

	@Override
	public boolean hasChildren(Integer[] id) {
		for(Integer typeId : id) {
			int count = sysDictMapper.countDictChildren(typeId);
			if(count > 0) {
				return true;
			}
		}
		return false;
	}

}
