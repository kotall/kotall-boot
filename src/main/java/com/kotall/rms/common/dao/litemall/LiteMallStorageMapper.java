package com.kotall.rms.common.dao.litemall;


import com.kotall.rms.common.dao.sys.BaseMapper;
import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.common.entity.litemall.LitemallStorageExample;
import org.apache.ibatis.annotations.Mapper;


/**
 * 文件存储表
 *
 * @author kotall
<<<<<<< HEAD
 * @date 2018年11月21日 下午2:11:06
=======
 * @date 2018年11月21日 上午11:42:26
>>>>>>> f540a6f71acc461f4aa521713565af657c4990a5
 * @since 1.0.0
 */
@Mapper
public interface LiteMallStorageMapper extends BaseMapper<LiteMallStorageEntity> {

    LiteMallStorageEntity findByKey(LitemallStorageExample example);

    void add(LiteMallStorageEntity storageInfo);
}
