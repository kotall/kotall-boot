package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallUserFormidEntity;
import com.kotall.rms.core.manager.litemall.LiteMallUserFormidManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallUserFormidService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月20日 下午1:56:37
 * @since 1.0.0
 */
@Service("liteMallUserFormidService")
public class LiteMallUserFormidServiceImpl extends BaseServiceImpl<LiteMallUserFormidManager, LiteMallUserFormidEntity> implements LiteMallUserFormidService {

	@Autowired
	private LiteMallUserFormidManager liteMallUserFormidManager;

	@Override
	public LiteMallUserFormidEntity queryByOpenId(Map<String, Object> params) {
		List<LiteMallUserFormidEntity> list = this.queryByList(params);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		LiteMallUserFormidEntity data = list.get(0);
		Date expireTime = data.getExpireTime();
		if (expireTime.compareTo(new Date()) < 0) {
           return null;
		}
		return data;
	}

	@Override
	public boolean updateUserFormId(LiteMallUserFormidEntity userFormid) {
		// 更新或者删除缓存
		if (userFormid.getIsprepay() == 1 && userFormid.getUseamount() > 1) {
			userFormid.setUseamount(userFormid.getUseamount() - 1);
			userFormid.setUpdateTime(new Date());
			return liteMallUserFormidManager.update(userFormid);
		} else {
			return liteMallUserFormidManager.deleteByIds(new Integer[] {userFormid.getId()});
		}
	}
}
