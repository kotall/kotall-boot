package com.kotall.rms.web.controller.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.web.controller.sys.AbstractController;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
        import com.kotall.rms.web.util.ResultKit;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;
import com.kotall.rms.core.service.litemall.LiteMallGoodsProductService;

/**
 * 商品货品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:58:29
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/goodsproduct")
public class LiteMallGoodsProductController extends AbstractController {
	
	@Autowired
	private LiteMallGoodsProductService liteMallGoodsProductService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallGoodsProductEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallGoodsProductService.queryByPage(params);
	}
		
	/**
	 * 新增
	 * @param liteMallGoodsProduct
	 * @return
	 */
	@SysLog("新增商品货品表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallGoodsProductEntity liteMallGoodsProduct) {
		boolean count = liteMallGoodsProductService.save(liteMallGoodsProduct);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Integer id) {
		LiteMallGoodsProductEntity liteMallGoodsProduct = liteMallGoodsProductService.getById(id);
		return ResultKit.msg(liteMallGoodsProduct);
	}
	
	/**
	 * 修改
	 * @param liteMallGoodsProduct
	 * @return
	 */
	@SysLog("修改商品货品表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallGoodsProductEntity liteMallGoodsProduct) {
		boolean count = liteMallGoodsProductService.update(liteMallGoodsProduct);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除商品货品表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Integer[] id) {
		boolean count = liteMallGoodsProductService.deleteByIds(id);
		return ResultKit.msg(count);
	}

	/**
	 * 列表
	 * @return
	 */
	@RequestMapping("/getByGoodsId")
	public Result getByGoodsId(String goodsId) {
		return ResultKit.msg(liteMallGoodsProductService.getByGoodsId(goodsId));
	}
	
}
