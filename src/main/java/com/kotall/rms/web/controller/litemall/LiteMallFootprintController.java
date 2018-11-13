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
import com.kotall.rms.common.entity.litemall.LiteMallFootprintEntity;
import com.kotall.rms.core.service.litemall.LiteMallFootprintService;

/**
 * 用户浏览足迹表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:10:19
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/footprint")
public class LiteMallFootprintController extends AbstractController {
	
	@Autowired
	private LiteMallFootprintService liteMallFootprintService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallFootprintEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallFootprintService.listLiteMallFootprint(params);
	}
		
	/**
	 * 新增
	 * @param liteMallFootprint
	 * @return
	 */
	@SysLog("新增用户浏览足迹表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallFootprintEntity liteMallFootprint) {
	    int count = liteMallFootprintService.saveLiteMallFootprint(liteMallFootprint);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallFootprintEntity liteMallFootprint = liteMallFootprintService.getLiteMallFootprintById(id);
		return ResultKit.msg(liteMallFootprint);
	}
	
	/**
	 * 修改
	 * @param liteMallFootprint
	 * @return
	 */
	@SysLog("修改用户浏览足迹表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallFootprintEntity liteMallFootprint) {
        int count = liteMallFootprintService.updateLiteMallFootprint(liteMallFootprint);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除用户浏览足迹表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallFootprintService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
