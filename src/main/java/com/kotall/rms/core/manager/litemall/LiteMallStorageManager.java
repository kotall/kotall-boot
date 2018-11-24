package com.kotall.rms.core.manager.litemall;


import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.common.entity.litemall.LitemallStorageExample;
import com.kotall.rms.core.manager.BaseManager;

/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 下午2:11:06
 * @since 1.0.0
 */
public interface LiteMallStorageManager extends BaseManager<LiteMallStorageEntity> {

	LiteMallStorageEntity findByKey(LitemallStorageExample example);

}
