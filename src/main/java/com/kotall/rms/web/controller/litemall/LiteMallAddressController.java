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
import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;
import com.kotall.rms.core.service.litemall.LiteMallAddressService;

/**
 * 收货地址管理
 *
 * @author kotall
 * @date 2018年11月13日 上午11:28:53
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/address")
public class LiteMallAddressController extends AbstractController {
	
	@Autowired
	private LiteMallAddressService liteMallAddressService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallAddressEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallAddressService.queryByPage(params);
	}
		
	/**
	 * 新增
	 * @param liteMallAddress
	 * @return
	 */
	@SysLog("新增收货地址表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallAddressEntity liteMallAddress) {
	    boolean count = liteMallAddressService.save(liteMallAddress);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Integer id) {
		LiteMallAddressEntity liteMallAddress = liteMallAddressService.getById(id);
		return ResultKit.msg(liteMallAddress);
	}
	
	/**
	 * 修改
	 * @param liteMallAddress
	 * @return
	 */
	@SysLog("修改收货地址表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallAddressEntity liteMallAddress) {
		boolean count = liteMallAddressService.update(liteMallAddress);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除收货地址表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Integer[] id) {
		boolean count = liteMallAddressService.deleteByIds(id);
		return ResultKit.msg(count);
	}
	
}
