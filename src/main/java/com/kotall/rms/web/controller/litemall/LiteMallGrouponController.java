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
import com.kotall.rms.common.entity.litemall.LiteMallGrouponEntity;
import com.kotall.rms.core.service.litemall.LiteMallGrouponService;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:32:18
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/grouponactivity")
public class LiteMallGrouponController extends AbstractController {
	
	@Autowired
	private LiteMallGrouponService liteMallGrouponService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallGrouponEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallGrouponService.listLiteMallGroupon(params);
	}
		
	/**
	 * 新增
	 * @param liteMallGroupon
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallGrouponEntity liteMallGroupon) {
	    int count = liteMallGrouponService.saveLiteMallGroupon(liteMallGroupon);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallGrouponEntity liteMallGroupon = liteMallGrouponService.getLiteMallGrouponById(id);
		return ResultKit.msg(liteMallGroupon);
	}
	
	/**
	 * 修改
	 * @param liteMallGroupon
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallGrouponEntity liteMallGroupon) {
        int count = liteMallGrouponService.updateLiteMallGroupon(liteMallGroupon);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallGrouponService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
