package com.kotall.rms.web.controller.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.web.controller.sys.AbstractController;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
        import com.kotall.rms.web.util.ResultKit;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsAttributeEntity;
import com.kotall.rms.core.service.litemall.LiteMallGoodsAttributeService;

/**
 * 商品参数表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:51:23
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/attribute")
public class LiteMallGoodsAttributeController extends AbstractController {
	
	@Autowired
	private LiteMallGoodsAttributeService liteMallGoodsAttributeService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallGoodsAttributeEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallGoodsAttributeService.queryByPage(params);
	}
		
	/**
	 * 新增
	 * @param liteMallGoodsAttribute
	 * @return
	 */
	@SysLog("新增商品参数表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallGoodsAttributeEntity liteMallGoodsAttribute) {
	    boolean count = liteMallGoodsAttributeService.save(liteMallGoodsAttribute);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Integer id) {
		LiteMallGoodsAttributeEntity liteMallGoodsAttribute = liteMallGoodsAttributeService.getById(id);
		return ResultKit.msg(liteMallGoodsAttribute);
	}
	
	/**
	 * 修改
	 * @param liteMallGoodsAttribute
	 * @return
	 */
	@SysLog("修改商品参数表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallGoodsAttributeEntity liteMallGoodsAttribute) {
		boolean count = liteMallGoodsAttributeService.update(liteMallGoodsAttribute);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除商品参数表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Integer[] id) {
		boolean count = liteMallGoodsAttributeService.deleteByIds(id);
		return ResultKit.msg(count);
	}

	/**
	 * 列表
	 * @return
	 */
	@RequestMapping("/getByGoodsId")
	public Result getByGoodsId(String goodsId) {
		return ResultKit.msg(liteMallGoodsAttributeService.getByGoodsId(goodsId));
	}
}
