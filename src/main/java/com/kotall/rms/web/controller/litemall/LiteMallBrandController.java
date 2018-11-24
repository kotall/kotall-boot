package com.kotall.rms.web.controller.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallBrandEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.core.service.litemall.LiteMallBrandService;
import com.kotall.rms.web.controller.sys.AbstractController;
import com.kotall.rms.web.util.ResultKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 品牌商表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:48:32
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/brand")
public class LiteMallBrandController extends AbstractController {
	
	@Autowired
	private LiteMallBrandService liteMallBrandService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallBrandEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallBrandService.queryByPage(params);
	}
		
	/**
	 * 新增
	 * @param liteMallBrand
	 * @return
	 */
	@SysLog("新增品牌商表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallBrandEntity liteMallBrand) {
	    boolean count = liteMallBrandService.save(liteMallBrand);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Integer id) {
		LiteMallBrandEntity liteMallBrand = liteMallBrandService.getById(id);
		return ResultKit.msg(liteMallBrand);
	}
	
	/**
	 * 修改
	 * @param liteMallBrand
	 * @return
	 */
	@SysLog("修改品牌商表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallBrandEntity liteMallBrand) {
		boolean count = liteMallBrandService.update(liteMallBrand);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除品牌商表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Integer[] id) {
		boolean count = liteMallBrandService.deleteByIds(id);
		return ResultKit.msg(count);
	}
	
}
