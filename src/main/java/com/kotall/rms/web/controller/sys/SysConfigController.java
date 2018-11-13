package com.kotall.rms.web.controller.sys;

import com.kotall.rms.common.annotation.SysLog;
import com.kotall.rms.common.entity.sys.SysConfigEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.sys.SysConfigService;
import com.kotall.rms.web.util.ResultKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 系统配置信息表
 *
 * @author kotall
 * @date 2018年11月12日 下午9:18:45
 * @since 1.0.0
 */
@RestController
@RequestMapping("/config")
public class SysConfigController extends AbstractController {
	
	@Autowired
	private SysConfigService sysConfigService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SysConfigEntity> list(@RequestBody Map<String, Object> params) {
		return sysConfigService.listSysConfig(params);
	}
		
	/**
	 * 新增
	 * @param sysConfig
	 * @return
	 */
	@SysLog("新增系统配置信息表")
	@RequestMapping("/save")
	public Result save(@RequestBody SysConfigEntity sysConfig) {
	    int count = sysConfigService.saveSysConfig(sysConfig);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		SysConfigEntity sysConfig = sysConfigService.getSysConfigById(id);
		return ResultKit.msg(sysConfig);
	}
	
	/**
	 * 修改
	 * @param sysConfig
	 * @return
	 */
	@SysLog("修改系统配置信息表")
	@RequestMapping("/update")
	public Result update(@RequestBody SysConfigEntity sysConfig) {
        int count = sysConfigService.updateSysConfig(sysConfig);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除系统配置信息表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = sysConfigService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
