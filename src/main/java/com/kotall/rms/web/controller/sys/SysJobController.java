package com.kotall.rms.web.controller.sys;

import com.kotall.rms.common.entity.sys.SysJobEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.core.service.sys.SysJobService;
import com.kotall.rms.web.util.ResultKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:51:24
 */
@RestController
@RequestMapping("/sys/job")
public class SysJobController {

	@Autowired
	private SysJobService sysJobService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SysJobEntity> list(@RequestBody Map<String, Object> params) {
		return sysJobService.queryByPage(params);
	}
	
	/**
	 * 新增任务
	 * @param job
	 * @return
	 */
	@SysLog("新增定时任务")
	@RequestMapping("/save")
	public Result save(@RequestBody SysJobEntity job) {
		boolean count = sysJobService.saveQuartzJob(job);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result info(@RequestBody Integer id) {
		SysJobEntity job = sysJobService.getById(id);
		return ResultKit.msg(job);
	}
	
	/**
	 * 修改任务
	 * @param job
	 * @return
	 */
	@SysLog("修改定时任务")
	@RequestMapping("/update")
	public Result update(@RequestBody SysJobEntity job) {
		boolean count = sysJobService.updateQuartzJob(job);
		return ResultKit.msg(count);
	}
	
	/**
	 * 删除定时任务
	 * @param id
	 * @return
	 */
	@SysLog("删除定时任务")
	@RequestMapping("/remove")
	public Result remove(@RequestBody Integer[] id) {
		boolean count = sysJobService.batchRemoveQuartzJob(id);
		return ResultKit.msg(count);
	}
	
	/**
	 * 立即运行
	 * @param id
	 * @return
	 */
	@SysLog("立即运行定时任务")
	@RequestMapping("/run")
	public Result run(@RequestBody Integer[] id) {
		int count = sysJobService.run(id);
		return ResultKit.msg(count);
	}
	
	/**
	 * 暂停任务
	 * @param id
	 * @return
	 */
	@SysLog("暂停定时运行")
	@RequestMapping("/disable")
	public Result pause(@RequestBody Integer[] id) {
		int count = sysJobService.pause(id);
		return ResultKit.msg(id, count);
	}
	
	/**
	 * 启用任务
	 * @param id
	 * @return
	 */
	@SysLog("启用定时任务")
	@RequestMapping("/enable")
	public Result resume(@RequestBody Integer[] id) {
		int count = sysJobService.resume(id);
		return ResultKit.msg(id, count);
	}
	
}
