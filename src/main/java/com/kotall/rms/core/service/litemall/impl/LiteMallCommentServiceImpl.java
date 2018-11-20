package com.kotall.rms.core.service.litemall.impl;

import java.util.HashMap;
import java.util.Map;

import com.kotall.rms.core.annotation.StoreFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallCommentEntity;
import com.kotall.rms.core.manager.litemall.LiteMallCommentManager;
import com.kotall.rms.core.service.litemall.LiteMallCommentService;

/**
 * 评论表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:55:35
 * @since 1.0.0
 */
@Service("liteMallCommentService")
public class LiteMallCommentServiceImpl implements LiteMallCommentService {

	@Autowired
	private LiteMallCommentManager liteMallCommentManager;

	@StoreFilter
	@Override
	public Page<LiteMallCommentEntity> listLiteMallComment(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallCommentEntity> page = new Page<>(query);
		liteMallCommentManager.listLiteMallComment(page, query);
		return page;
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
		Query query = new Query(params);
		Page<LiteMallCommentEntity> page = new Page<>(query);
		this.liteMallCommentManager.listLiteMallComment(page, query);
		return page;
	}

	@Override
	public int saveLiteMallComment(LiteMallCommentEntity role) {
		int count = liteMallCommentManager.saveLiteMallComment(role);
		return count;
	}

	@Override
	public LiteMallCommentEntity getLiteMallCommentById(Long id) {
		LiteMallCommentEntity liteMallComment = liteMallCommentManager.getLiteMallCommentById(id);
		return liteMallComment;
	}

	@Override
	public int updateLiteMallComment(LiteMallCommentEntity liteMallComment) {
		int count = liteMallCommentManager.updateLiteMallComment(liteMallComment);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallCommentManager.batchRemove(id);
		return count;
	}

	@Override
	public int count(int showType, int type, int valueId) {
		Map<String, Object> params = new HashMap<>();
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
