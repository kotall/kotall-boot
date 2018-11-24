package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.common.entity.litemall.LitemallStorageExample;
import com.kotall.rms.core.manager.litemall.LiteMallStorageManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;


/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 下午2:11:06
 * @since 1.0.0
 */
@Service("liteMallStorageService")
public class LiteMallStorageServiceImpl extends BaseServiceImpl<LiteMallStorageManager, LiteMallStorageEntity> implements LiteMallStorageService {

	@Autowired
	private LiteMallStorageManager liteMallStorageManager;

	@Override
	public LiteMallStorageEntity findByKey(String key) {
		LitemallStorageExample example = new LitemallStorageExample();
		example.or().andKeyEqualTo(key).andDeletedEqualTo(false);
		return liteMallStorageManager.findByKey(example);
	}

	@Override
	public String store(InputStream inputStream, long size, String contentType, String originalFilename) {
		return null;
	}

}
