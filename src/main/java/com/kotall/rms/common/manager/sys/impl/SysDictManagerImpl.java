package com.kotall.rms.common.manager.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kotall.rms.common.dao.sys.SysDictMapper;
import com.kotall.rms.common.entity.sys.SysDictEntity;
import com.kotall.rms.common.manager.sys.SysDictManager;

/**
 * 通用字典
 *
 * @author aracwong
 * @date 2017年8月15日 下午12:49:26
 */
@Component("sysDictManager")
public class SysDictManagerImpl implements SysDictManager {

	@Autowired
	private SysDictMapper sysDictMapper;
	
	@Override
	public List<SysDictEntity> listMacro() {
		return sysDictMapper.list();
	}

	@Override
	public List<SysDictEntity> listNotMacro() {
		return sysDictMapper.listNotDict();
	}

	@Override
	public int saveMacro(SysDictEntity macro) {
		return sysDictMapper.save(macro);
	}

	@Override
	public SysDictEntity getObjectById(Long id) {
		return sysDictMapper.getObjectById(id);
	}

	@Override
	public int updateMacro(SysDictEntity macro) {
		return sysDictMapper.update(macro);
	}

	@Override
	public int batchRemove(Long[] id) {
		return sysDictMapper.batchRemove(id);
	}
	
	@Override
	public boolean hasChildren(Long[] id) {
		for(Long typeId : id) {
			int count = sysDictMapper.countDictChildren(typeId);
			if(count > 0) {
				return true;
			}
		}
		return false;
	}

}
