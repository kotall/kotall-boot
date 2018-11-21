package com.kotall.rms.core.service.litemall.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsAttributeEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsAttributeManager;
import com.kotall.rms.core.service.litemall.LiteMallGoodsAttributeService;

/**
 * 商品参数表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:51:23
 * @since 1.0.0
 */
@Service("liteMallGoodsAttributeService")
public class LiteMallGoodsAttributeServiceImpl implements LiteMallGoodsAttributeService {

	@Autowired
	private LiteMallGoodsAttributeManager liteMallGoodsAttributeManager;

	@Override
	public Page<LiteMallGoodsAttributeEntity> listLiteMallGoodsAttribute(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallGoodsAttributeEntity> page = new Page<>(query);
		liteMallGoodsAttributeManager.listLiteMallGoodsAttribute(page, query);
		return page;
	}

	@Override
	public List<LiteMallGoodsAttributeEntity> queryGoodsAttributeList(Map<String, Object> params) {
		Query query = new Query(params);
		return liteMallGoodsAttributeManager.queryGoodsAttributeList(query);
	}

	@Override
	public List<LiteMallGoodsAttributeEntity> queryByGid(Map<String, Object> params) {
		return this.queryGoodsAttributeList(params);
	}

	@Override
	public int saveLiteMallGoodsAttribute(LiteMallGoodsAttributeEntity role) {
		int count = liteMallGoodsAttributeManager.saveLiteMallGoodsAttribute(role);
		return count;
	}

	@Override
	public LiteMallGoodsAttributeEntity getLiteMallGoodsAttributeById(Long id) {
		LiteMallGoodsAttributeEntity liteMallGoodsAttribute = liteMallGoodsAttributeManager.getLiteMallGoodsAttributeById(id);
		return liteMallGoodsAttribute;
	}

	@Override
	public int updateLiteMallGoodsAttribute(LiteMallGoodsAttributeEntity liteMallGoodsAttribute) {
		int count = liteMallGoodsAttributeManager.updateLiteMallGoodsAttribute(liteMallGoodsAttribute);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallGoodsAttributeManager.batchRemove(id);
		return count;
	}

}
