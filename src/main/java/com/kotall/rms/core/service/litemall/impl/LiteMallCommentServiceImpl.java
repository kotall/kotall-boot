package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallCommentEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallCommentManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 评论表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:55:35
 * @since 1.0.0
 */
@Service("liteMallCommentService")
public class LiteMallCommentServiceImpl extends BaseServiceImpl<LiteMallCommentManager, LiteMallCommentEntity> implements LiteMallCommentService {

	@Autowired
	private LiteMallCommentManager liteMallCommentManager;

	@StoreFilter
	@Override
	public Page<LiteMallCommentEntity> queryCommentByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}

	@Override
	public Page<LiteMallCommentEntity> queryCommentByPage(Integer showType, Map<String, Object> params) {
		if(showType == 0) {
		}
		else if(showType == 1){
			params.put("hasPicture", 1);
		}
		else{
			throw new RuntimeException("showType不支持");
		}
		return super.queryByPage(params);
	}

	@Override
	public int count(Integer storeId, int showType, int type, int valueId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("type", type);
		params.put("valueId", valueId);
		params.put("deleted", 0);
		if(showType == 0) {
		}
		else if(showType == 1){
			params.put("hasPicture", 1);
		}
		else{
			throw new RuntimeException("showType不支持");
		}
		Query query = new Query(params);
		return this.liteMallCommentManager.countComment(query);
	}
}
