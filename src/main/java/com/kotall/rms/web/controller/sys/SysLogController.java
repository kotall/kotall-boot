package com.kotall.rms.web.controller.sys;

import java.util.Map;

import com.kotall.rms.common.utils.Result;
import com.kotall.rms.web.util.ResultKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotall.rms.common.annotation.SysLog;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysLogEntity;
import com.kotall.rms.core.service.sys.SysLogService;

/**
 * 系统日志
 *
 * @author aracwong
 * @date 2017年8月14日 下午10:01:36
 */
@RestController
@RequestMapping("/sys/log")
public class SysLogController extends AbstractController {

	@Autowired
	private SysLogService sysLogService;
	
	/**
	 * 日志列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SysLogEntity> listLog(@RequestBody Map<String, Object> params) {
		return sysLogService.listLog(params);
	}
	
	/**
	 * 删除日志
	 * @param id
	 * @return
	 */
	@SysLog("删除日志")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		int count = sysLogService.batchRemove(id);
		return ResultKit.msg(id, count);
	}
	
	/**
	 * 清空日志
	 * @return
	 */
	@SysLog("清空日志")
	@RequestMapping("/clear")
	public Result batchRemoveAll() {
		int count = sysLogService.batchRemoveAll();
		return ResultKit.msg(count);
	}
	
}
