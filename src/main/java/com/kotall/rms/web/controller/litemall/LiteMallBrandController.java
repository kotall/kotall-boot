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
import com.kotall.rms.common.entity.litemall.LiteMallBrandEntity;
import com.kotall.rms.core.service.litemall.LiteMallBrandService;

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
		return liteMallBrandService.listLiteMallBrand(params);
	}
		
	/**
	 * 新增
	 * @param liteMallBrand
	 * @return
	 */
	@SysLog("新增品牌商表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallBrandEntity liteMallBrand) {
	    int count = liteMallBrandService.saveLiteMallBrand(liteMallBrand);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallBrandEntity liteMallBrand = liteMallBrandService.getLiteMallBrandById(id);
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
        int count = liteMallBrandService.updateLiteMallBrand(liteMallBrand);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除品牌商表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallBrandService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
