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
import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.core.service.litemall.LiteMallUserService;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午10:18:32
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/user")
public class LiteMallUserController extends AbstractController {
	
	@Autowired
	private LiteMallUserService liteMallUserService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallUserEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallUserService.listLiteMallUser(params);
	}
		
	/**
	 * 新增
	 * @param liteMallUser
	 * @return
	 */
	@SysLog("新增用户表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallUserEntity liteMallUser) {
	    int count = liteMallUserService.saveLiteMallUser(liteMallUser);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallUserEntity liteMallUser = liteMallUserService.getLiteMallUserById(id);
		return ResultKit.msg(liteMallUser);
	}
	
	/**
	 * 修改
	 * @param liteMallUser
	 * @return
	 */
	@SysLog("修改用户表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallUserEntity liteMallUser) {
        int count = liteMallUserService.updateLiteMallUser(liteMallUser);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除用户表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallUserService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
