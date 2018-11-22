package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallGoodsAttributeMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsAttributeEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsAttributeManager;

/**
 * 商品参数表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:51:23
 * @since 1.0.0
 */
@Component("liteMallGoodsAttributeManager")
public class LiteMallGoodsAttributeManagerImpl implements LiteMallGoodsAttributeManager {

	@Autowired
	private LiteMallGoodsAttributeMapper liteMallGoodsAttributeMapper;
	

	@Override
	public List<LiteMallGoodsAttributeEntity> listLiteMallGoodsAttribute(Page<LiteMallGoodsAttributeEntity> page, Query search) {
		return liteMallGoodsAttributeMapper.listForPage(page, search);
	}

	@Override
	public List<LiteMallGoodsAttributeEntity> queryGoodsAttributeList(Query query) {
		return liteMallGoodsAttributeMapper.list(query);
	}

	@Override
	public int saveLiteMallGoodsAttribute(LiteMallGoodsAttributeEntity liteMallGoodsAttribute) {
		return liteMallGoodsAttributeMapper.save(liteMallGoodsAttribute);
	}

	@Override
	public LiteMallGoodsAttributeEntity getLiteMallGoodsAttributeById(Long id) {
		LiteMallGoodsAttributeEntity liteMallGoodsAttribute = liteMallGoodsAttributeMapper.getObjectById(id);
		return liteMallGoodsAttribute;
	}

	@Override
	public int updateLiteMallGoodsAttribute(LiteMallGoodsAttributeEntity liteMallGoodsAttribute) {
		return liteMallGoodsAttributeMapper.update(liteMallGoodsAttribute);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallGoodsAttributeMapper.batchRemove(id);
		return count;
	}
	
}
