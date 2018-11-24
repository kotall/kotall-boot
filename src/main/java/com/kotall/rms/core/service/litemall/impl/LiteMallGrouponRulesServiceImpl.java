package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.common.entity.litemall.LiteMallGrouponRulesEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsManager;
import com.kotall.rms.core.manager.litemall.LiteMallGrouponRulesManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallGrouponRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:25:19
 * @since 1.0.0
 */
@Service("liteMallGrouponRulesService")
public class LiteMallGrouponRulesServiceImpl extends BaseServiceImpl<LiteMallGrouponRulesManager, LiteMallGrouponRulesEntity> implements LiteMallGrouponRulesService {

	@Autowired
	private LiteMallGrouponRulesManager liteMallGrouponRulesManager;
	@Autowired
	private LiteMallGoodsManager liteMallGoodsManager;

	@StoreFilter
	@Override
	public Page<LiteMallGrouponRulesEntity> queryGrouponRulesByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}


	@Override
	public Page<Map<String, Object>> queryGroupOnList(Map<String, Object> params) {
		params.put("deleted", 0);
		Page<LiteMallGrouponRulesEntity> page = super.queryByPage(params);
		List<LiteMallGrouponRulesEntity> grouponRules = page.getRows();
		List<Map<String, Object>> grouponList =  new ArrayList<>(grouponRules.size());
		for (LiteMallGrouponRulesEntity rule : grouponRules) {
			Integer goodsId = rule.getGoodsId();
			LiteMallGoodsEntity goods = liteMallGoodsManager.getById(goodsId);
			if (goods == null)
				continue;

			Map<String, Object> item = new HashMap<>();
			item.put("goods", goods);
			item.put("groupon_price", goods.getRetailPrice().subtract(rule.getDiscount()));
			item.put("groupon_member", rule.getDiscountMember());
			grouponList.add(item);
		}

		Page<Map<String, Object>> newPage = new Page<>();
		newPage.setRows(grouponList);
		newPage.setTotal(page.getTotal());
		return newPage;
	}

	@Override
	public List<LiteMallGrouponRulesEntity> queryByGoodsId(Map<String, Object> params) {
		return this.queryByList(params);
	}

	/**
	 * 判断某个团购活动是否已经过期
	 *
	 * @return
	 */
	public boolean isExpired(LiteMallGrouponRulesEntity rules) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(rules.getExpireTime());

		return (rules == null || calendar.before(new Date()));
	}
}
