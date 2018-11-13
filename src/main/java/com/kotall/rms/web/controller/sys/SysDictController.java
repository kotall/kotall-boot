package com.kotall.rms.web.controller.sys;

import java.util.List;

import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.exception.RmsException;
import com.kotall.rms.web.util.ResultKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotall.rms.common.annotation.SysLog;
import com.kotall.rms.common.entity.sys.SysDictEntity;
import com.kotall.rms.core.service.sys.SysDictService;

/**
 * 通用字典
 *
 * @author aracwong
 * @date 2017年8月15日 下午12:54:33
 */
@RestController
@RequestMapping("/sys/dict")
public class SysDictController extends AbstractController {

	@Autowired
	private SysDictService sysDictService;
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping("/list")
	public List<SysDictEntity> list() {
		return sysDictService.listDict();
	}
	
	/**
	 * 树形列表
	 * @return
	 */
	@RequestMapping("/select")
	public List<SysDictEntity> select() {
		return sysDictService.listNotMacro();
	}
	
	/**
	 * 新增字典
	 * @param macro
	 * @return
	 */
	@SysLog("新增字典")
	@RequestMapping("/save")
	public Result save(@RequestBody SysDictEntity macro) {
		int count = sysDictService.saveDict(macro);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result info(@RequestBody Long id) {
		SysDictEntity dict = sysDictService.getObjectById(id);
		return ResultKit.msg(dict);
	}
	
	/**
	 * 修改字典
	 * @param macro
	 * @return
	 */
	@SysLog("修改字典")
	@RequestMapping("/update")
	public Result update(@RequestBody SysDictEntity macro) {
		int count = sysDictService.updateDict(macro);
		return ResultKit.msg(count);
	}
	
	/**
	 * 删除字典
	 * @param id
	 * @return
	 */
	@SysLog("删除字典")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		try {
			int count = sysDictService.batchRemove(id);
			return ResultKit.msg(id, count);
		} catch (RmsException e) {
			return Result.error(e.getMsg());
		}
	}
	
}
