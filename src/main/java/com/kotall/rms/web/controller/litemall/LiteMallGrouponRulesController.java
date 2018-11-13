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
import com.kotall.rms.common.entity.litemall.LiteMallGrouponRulesEntity;
import com.kotall.rms.core.service.litemall.LiteMallGrouponRulesService;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:25:19
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/grouponrules")
public class LiteMallGrouponRulesController extends AbstractController {
	
	@Autowired
	private LiteMallGrouponRulesService liteMallGrouponRulesService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallGrouponRulesEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallGrouponRulesService.listLiteMallGrouponRules(params);
	}
		
	/**
	 * 新增
	 * @param liteMallGrouponRules
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallGrouponRulesEntity liteMallGrouponRules) {
	    int count = liteMallGrouponRulesService.saveLiteMallGrouponRules(liteMallGrouponRules);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallGrouponRulesEntity liteMallGrouponRules = liteMallGrouponRulesService.getLiteMallGrouponRulesById(id);
		return ResultKit.msg(liteMallGrouponRules);
	}
	
	/**
	 * 修改
	 * @param liteMallGrouponRules
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallGrouponRulesEntity liteMallGrouponRules) {
        int count = liteMallGrouponRulesService.updateLiteMallGrouponRules(liteMallGrouponRules);
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
	    int count = liteMallGrouponRulesService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
