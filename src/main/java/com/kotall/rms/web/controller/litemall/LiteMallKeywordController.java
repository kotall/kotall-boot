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
import com.kotall.rms.common.entity.litemall.LiteMallKeywordEntity;
import com.kotall.rms.core.service.litemall.LiteMallKeywordService;

/**
 * 关键字表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:34:40
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/keyword")
public class LiteMallKeywordController extends AbstractController {
	
	@Autowired
	private LiteMallKeywordService liteMallKeywordService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallKeywordEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallKeywordService.listLiteMallKeyword(params);
	}
		
	/**
	 * 新增
	 * @param liteMallKeyword
	 * @return
	 */
	@SysLog("新增关键字表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallKeywordEntity liteMallKeyword) {
	    int count = liteMallKeywordService.saveLiteMallKeyword(liteMallKeyword);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallKeywordEntity liteMallKeyword = liteMallKeywordService.getLiteMallKeywordById(id);
		return ResultKit.msg(liteMallKeyword);
	}
	
	/**
	 * 修改
	 * @param liteMallKeyword
	 * @return
	 */
	@SysLog("修改关键字表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallKeywordEntity liteMallKeyword) {
        int count = liteMallKeywordService.updateLiteMallKeyword(liteMallKeyword);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除关键字表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallKeywordService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
