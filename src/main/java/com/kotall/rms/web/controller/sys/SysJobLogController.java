package com.kotall.rms.web.controller.sys;

import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.web.util.ResultKit;
import com.kotall.rms.common.entity.sys.SysJobLogEntity;
import com.kotall.rms.core.service.sys.SysJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author aracwong
 * @date 2017年8月21日 上午11:48:14
 */
@RestController
@RequestMapping("/sys/job/log")
public class SysJobLogController {

	@Autowired
	private SysJobLogService sysJobLogService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SysJobLogEntity> list(@RequestBody Map<String, Object> params) {
		return sysJobLogService.listForPage(params);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除定时任务日志")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		int count = sysJobLogService.batchRemove(id);
		return ResultKit.msg(id, count);
	}
	
	/**
	 * 清空
	 * @return
	 */
	@SysLog("清空定时任务日志")
	@RequestMapping("/clear")
	public Result batchRemoveAll() {
		int count = sysJobLogService.batchRemoveAll();
		return ResultKit.msg(count);
	}
	
}
