package com.kotall.rms.web.controller.sys;

import com.kotall.rms.common.entity.sys.SysDictEntity;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.core.service.sys.SysDictService;
import com.kotall.rms.web.util.ResultKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
		return sysDictService.listNotDict();
	}
	
	/**
	 * 新增字典
	 * @param macro
	 * @return
	 */
	@SysLog("新增字典")
	@RequestMapping("/save")
	public Result save(@RequestBody SysDictEntity macro) {
		boolean count = sysDictService.save(macro);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result info(@RequestBody Integer id) {
		SysDictEntity dict = sysDictService.getById(id);
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
		boolean count = sysDictService.update(macro);
		return ResultKit.msg(count);
	}
	
	/**
	 * 删除字典
	 * @param id
	 * @return
	 */
	@SysLog("删除字典")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Integer[] id) {
		try {
			boolean count = sysDictService.removeByIds(id);
			return ResultKit.msg(count);
		} catch (RmsException e) {
			return Result.error(e.getMsg());
		}
	}
	
}
