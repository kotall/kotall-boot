package com.kotall.rms.common.dao.sys;

import java.util.List;

import com.kotall.rms.common.entity.sys.SysDictEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 通用字典
 *
 * @author aracwong
 * @date 2017年8月15日 下午12:46:31
 */
@Mapper
public interface SysDictMapper extends BaseMapper<SysDictEntity> {

	List<SysDictEntity> listNotDict();
	
	int countDictChildren(Integer typeId);
	
}
