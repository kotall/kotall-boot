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
import com.kotall.rms.common.entity.litemall.LiteMallUserFormidEntity;
import com.kotall.rms.core.service.litemall.LiteMallUserFormidService;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月20日 下午1:56:37
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/userformid")
public class LiteMallUserFormidController extends AbstractController {
	
	@Autowired
	private LiteMallUserFormidService liteMallUserFormidService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallUserFormidEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallUserFormidService.listLiteMallUserFormid(params);
	}
		
	/**
	 * 新增
	 * @param liteMallUserFormid
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallUserFormidEntity liteMallUserFormid) {
	    int count = liteMallUserFormidService.saveLiteMallUserFormid(liteMallUserFormid);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallUserFormidEntity liteMallUserFormid = liteMallUserFormidService.getLiteMallUserFormidById(id);
		return ResultKit.msg(liteMallUserFormid);
	}
	
	/**
	 * 修改
	 * @param liteMallUserFormid
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallUserFormidEntity liteMallUserFormid) {
        int count = liteMallUserFormidService.updateLiteMallUserFormid(liteMallUserFormid);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallUserFormidService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
