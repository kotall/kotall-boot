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
import com.kotall.rms.common.entity.litemall.LiteMallOrderGoodsEntity;
import com.kotall.rms.core.service.litemall.LiteMallOrderGoodsService;

/**
 * 订单商品表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:45:21
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/ordergoods")
public class LiteMallOrderGoodsController extends AbstractController {
	
	@Autowired
	private LiteMallOrderGoodsService liteMallOrderGoodsService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallOrderGoodsEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallOrderGoodsService.queryOrderGoodsByPage(params);
	}
		
	/**
	 * 新增
	 * @param liteMallOrderGoods
	 * @return
	 */
	@SysLog("新增订单商品表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallOrderGoodsEntity liteMallOrderGoods) {
		boolean count = liteMallOrderGoodsService.save(liteMallOrderGoods);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Integer id) {
		LiteMallOrderGoodsEntity liteMallOrderGoods = liteMallOrderGoodsService.getById(id);
		return ResultKit.msg(liteMallOrderGoods);
	}
	
	/**
	 * 修改
	 * @param liteMallOrderGoods
	 * @return
	 */
	@SysLog("修改订单商品表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallOrderGoodsEntity liteMallOrderGoods) {
		boolean count = liteMallOrderGoodsService.update(liteMallOrderGoods);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除订单商品表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Integer[] id) {
		boolean count = liteMallOrderGoodsService.deleteByIds(id);
		return ResultKit.msg(count);
	}
	
}
