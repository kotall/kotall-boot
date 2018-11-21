package com.kotall.rms.web.controller.litemall;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.web.controller.sys.AbstractController;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
        import com.kotall.rms.web.util.ResultKit;
import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.core.service.litemall.LiteMallStorageService;

/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 上午11:42:26
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/storage")
public class LiteMallStorageController extends AbstractController {
	
	@Autowired
	private LiteMallStorageService liteMallStorageService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallStorageEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallStorageService.listLiteMallStorage(params);
	}
		
	/**
	 * 新增
	 * @param liteMallStorage
	 * @return
	 */
	@SysLog("新增文件存储表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallStorageEntity liteMallStorage) {
	    int count = liteMallStorageService.saveLiteMallStorage(liteMallStorage);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallStorageEntity liteMallStorage = liteMallStorageService.getLiteMallStorageById(id);
		return ResultKit.msg(liteMallStorage);
	}
	
	/**
	 * 修改
	 * @param liteMallStorage
	 * @return
	 */
	@SysLog("修改文件存储表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallStorageEntity liteMallStorage) {
        int count = liteMallStorageService.updateLiteMallStorage(liteMallStorage);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除文件存储表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallStorageService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
