package com.kotall.rms.web.controller.litemall;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotall.rms.common.annotation.SysLog;
import com.kotall.rms.web.controller.sys.AbstractController;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
        import com.kotall.rms.web.util.ResultKit;
import com.kotall.rms.common.entity.litemall.LiteMallCollectEntity;
import com.kotall.rms.core.service.litemall.LiteMallCollectService;

/**
 * 收藏表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:41:28
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/collect")
public class LiteMallCollectController extends AbstractController {
	
	@Autowired
	private LiteMallCollectService liteMallCollectService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallCollectEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallCollectService.listLiteMallCollect(params);
	}
		
	/**
	 * 新增
	 * @param liteMallCollect
	 * @return
	 */
	@SysLog("新增收藏表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallCollectEntity liteMallCollect) {
	    int count = liteMallCollectService.saveLiteMallCollect(liteMallCollect);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallCollectEntity liteMallCollect = liteMallCollectService.getLiteMallCollectById(id);
		return ResultKit.msg(liteMallCollect);
	}
	
	/**
	 * 修改
	 * @param liteMallCollect
	 * @return
	 */
	@SysLog("修改收藏表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallCollectEntity liteMallCollect) {
        int count = liteMallCollectService.updateLiteMallCollect(liteMallCollect);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除收藏表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallCollectService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
