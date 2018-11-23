package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysDictEntity;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.core.enums.DictType;
import com.kotall.rms.core.enums.StatusType;
import com.kotall.rms.core.manager.sys.SysDictManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.sys.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用字典
 *
 * @author aracwong
 * @date 2017年8月15日 下午12:52:38
 */
@Service("sysDictService")
public class SysDictServiceImpl extends BaseServiceImpl<SysDictManager, SysDictEntity> implements SysDictService {

	@Autowired
	private SysDictManager sysDictManager;
	
	@Override
	public List<SysDictEntity> listDict() {
		return sysDictManager.listDict();
	}

	@Override
	public List<SysDictEntity> listNotDict() {
		List<SysDictEntity> macros = sysDictManager.listNotDict();
		SysDictEntity macro = new SysDictEntity();
		macro.setDictId(0L);
		macro.setTypeId(-1L);
		macro.setName("一级目录");
		macro.setOpen(true);
		macros.add(macro);
		return macros;
	}

	@Override
	public boolean removeByIds(Integer[] id) {
		boolean children = sysDictManager.hasChildren(id);
		if(children) {
			throw RmsException.HAS_CHILD_EXCEPTION;
		}
		boolean count = sysDictManager.deleteByIds(id);
		return count;
	}

	@Override
	public boolean save(SysDictEntity dict) {
		boolean count = sysDictManager.save(validate(dict));
		return count;
	}
	
	/**
	 * 当为参数类型时，状态为显示
	 * @param macro
	 * @return
	 */
	public SysDictEntity validate(SysDictEntity macro) {
		if(macro.getType() == DictType.TYPE.getValue()) {
			macro.setStatus(StatusType.SHOW.getValue());
		}
		return macro;
	}

}
