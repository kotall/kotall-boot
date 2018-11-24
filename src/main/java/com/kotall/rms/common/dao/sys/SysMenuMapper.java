package com.kotall.rms.common.dao.sys;

import java.util.List;

import com.kotall.rms.common.dao.BaseMapper;
import com.kotall.rms.common.entity.sys.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统菜单dao
 *
 * @author aracwong
 * @date 2017年8月10日 上午12:21:34
 * @since 1.0.0
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {
	
	List<SysMenuEntity> listParentId(Integer parentId);
	
	List<SysMenuEntity> listNotButton();
	
	List<String> listUserPerms(Integer userId);

	List<String> listAllPerms();
	
	int countMenuChildren(Integer parentId);

}
