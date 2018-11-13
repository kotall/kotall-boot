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
import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;
import com.kotall.rms.core.service.litemall.LiteMallCategoryService;

/**
 * 类目表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:12:36
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/category")
public class LiteMallCategoryController extends AbstractController {
	
	@Autowired
	private LiteMallCategoryService liteMallCategoryService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallCategoryEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallCategoryService.listLiteMallCategory(params);
	}
		
	/**
	 * 新增
	 * @param liteMallCategory
	 * @return
	 */
	@SysLog("新增类目表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallCategoryEntity liteMallCategory) {
	    int count = liteMallCategoryService.saveLiteMallCategory(liteMallCategory);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallCategoryEntity liteMallCategory = liteMallCategoryService.getLiteMallCategoryById(id);
		return ResultKit.msg(liteMallCategory);
	}
	
	/**
	 * 修改
	 * @param liteMallCategory
	 * @return
	 */
	@SysLog("修改类目表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallCategoryEntity liteMallCategory) {
        int count = liteMallCategoryService.updateLiteMallCategory(liteMallCategory);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除类目表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallCategoryService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
