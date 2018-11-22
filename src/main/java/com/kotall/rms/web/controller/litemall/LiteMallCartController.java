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
import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;
import com.kotall.rms.core.service.litemall.LiteMallCartService;

/**
 * 购物车商品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:39:39
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/litemall")
public class LiteMallCartController extends AbstractController {
	
	@Autowired
	private LiteMallCartService liteMallCartService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallCartEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallCartService.listLiteMallCart(params);
	}
		
	/**
	 * 新增
	 * @param liteMallCart
	 * @return
	 */
	@SysLog("新增购物车商品表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallCartEntity liteMallCart) {
	    int count = liteMallCartService.saveLiteMallCart(liteMallCart);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallCartEntity liteMallCart = liteMallCartService.getLiteMallCartById(id);
		return ResultKit.msg(liteMallCart);
	}
	
	/**
	 * 修改
	 * @param liteMallCart
	 * @return
	 */
	@SysLog("修改购物车商品表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallCartEntity liteMallCart) {
        int count = liteMallCartService.updateLiteMallCart(liteMallCart);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除购物车商品表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallCartService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
