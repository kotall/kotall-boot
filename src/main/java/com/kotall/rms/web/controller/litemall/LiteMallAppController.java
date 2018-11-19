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
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.core.service.litemall.LiteMallAppService;

/**
 * app配置表
 *
 * @author kotall
 * @date 2018年11月19日 上午10:17:16
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/app")
public class LiteMallAppController extends AbstractController {
	
	@Autowired
	private LiteMallAppService liteMallAppService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallAppEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallAppService.listLiteMallApp(params);
	}
		
	/**
	 * 新增
	 * @param liteMallApp
	 * @return
	 */
	@SysLog("新增app配置表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallAppEntity liteMallApp) {
	    int count = liteMallAppService.saveLiteMallApp(liteMallApp);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallAppEntity liteMallApp = liteMallAppService.getLiteMallAppById(id);
		return ResultKit.msg(liteMallApp);
	}
	
	/**
	 * 修改
	 * @param liteMallApp
	 * @return
	 */
	@SysLog("修改app配置表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallAppEntity liteMallApp) {
        int count = liteMallAppService.updateLiteMallApp(liteMallApp);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除app配置表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallAppService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
