package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallBrandEntity;

/**
 * 品牌商表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:48:32
 * @since 1.0.0
 */
public interface LiteMallBrandManager {

	List<LiteMallBrandEntity> listLiteMallBrand(Page<LiteMallBrandEntity> page, Query search);
	
	int saveLiteMallBrand(LiteMallBrandEntity liteMallBrand);
	
	LiteMallBrandEntity getLiteMallBrandById(Long id);
	
	int updateLiteMallBrand(LiteMallBrandEntity liteMallBrand);
	
	int batchRemove(Long[] id);
	
}
