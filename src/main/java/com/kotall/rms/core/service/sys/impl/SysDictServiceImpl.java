package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.core.enums.DictType;
import com.kotall.rms.core.enums.StatusType;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.common.entity.sys.SysDictEntity;
import com.kotall.rms.core.manager.sys.SysDictManager;
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
public class SysDictServiceImpl implements SysDictService {

	@Autowired
	private SysDictManager sysDictManager;
	
	@Override
	public List<SysDictEntity> listDict() {
		return sysDictManager.listMacro();
	}

	@Override
	public List<SysDictEntity> listNotMacro() {
		List<SysDictEntity> macros = sysDictManager.listNotMacro();
		SysDictEntity macro = new SysDictEntity();
		macro.setDictId(0L);
		macro.setTypeId(-1L);
		macro.setName("一级目录");
		macro.setOpen(true);
		macros.add(macro);
		return macros;
	}

	@Override
	public int saveDict(SysDictEntity macro) {
		int count = sysDictManager.saveMacro(validateMacro(macro));
		return count;
	}

	@Override
	public SysDictEntity getObjectById(Long id) {
		SysDictEntity dict = sysDictManager.getObjectById(id);
		return dict;
	}

	@Override
	public int updateDict(SysDictEntity macro) {
		int count = sysDictManager.updateMacro(validateMacro(macro));
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		boolean children = sysDictManager.hasChildren(id);
		if(children) {
			throw RmsException.HAS_CHILD_EXCEPTION;
		}
		int count = sysDictManager.batchRemove(id);
		return count;
	}
	
	/**
	 * 当为参数类型时，状态为显示
	 * @param macro
	 * @return
	 */
	public SysDictEntity validateMacro(SysDictEntity macro) {
		if(macro.getType() == DictType.TYPE.getValue()) {
			macro.setStatus(StatusType.SHOW.getValue());
		}
		return macro;
	}

}
