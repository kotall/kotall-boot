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
import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.core.service.litemall.LiteMallGoodsService;

/**
 * 商品基本信息表
 *
 * @author kotall
 * @date 2018年11月19日 下午3:03:30
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/goods")
public class LiteMallGoodsController extends AbstractController {
	
	@Autowired
	private LiteMallGoodsService liteMallGoodsService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallGoodsEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallGoodsService.queryGoodsByPage(params);
	}
		
	/**
	 * 新增
	 * @param liteMallGoods
	 * @return
	 */
	@SysLog("新增商品基本信息表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallGoodsEntity liteMallGoods) {
		boolean count = liteMallGoodsService.save(liteMallGoods);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Integer id) {
		LiteMallGoodsEntity liteMallGoods = liteMallGoodsService.getById(id);
		return ResultKit.msg(liteMallGoods);
	}
	
	/**
	 * 修改
	 * @param liteMallGoods
	 * @return
	 */
	@SysLog("修改商品基本信息表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallGoodsEntity liteMallGoods) {
		boolean count = liteMallGoodsService.update(liteMallGoods);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除商品基本信息表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Integer[] id) {
		liteMallGoodsService.deleteByIds(id);
		return ResultKit.msg(true);
	}
	
}
