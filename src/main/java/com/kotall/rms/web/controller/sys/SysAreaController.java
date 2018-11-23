package com.kotall.rms.web.controller.sys;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.web.util.ResultKit;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.common.entity.sys.SysAreaEntity;
import com.kotall.rms.core.service.sys.SysAreaService;

/**
 * 行政区域
 *
 * @author aracwong
 * @date 2017年8月18日 下午3:42:04
 */
@RestController
@RequestMapping("/sys/area")
@Slf4j
public class SysAreaController extends AbstractController {

	@Autowired
	private SysAreaService sysAreaService;
	
	/**
	 * 根据父级code查询子节点，子区域列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Result list(@RequestBody Map<String, Object> params) {
		List<SysAreaEntity> areas = sysAreaService.queryByList(params);
		return ResultKit.msg(areas);
	}
	
	/**
	 * 根据父级code查询子节点，树形目录
	 * @return
	 */
	@RequestMapping("/select")
	public List<SysAreaEntity> select(@RequestParam String areaCode) {
		return sysAreaService.listAreaByParentCode(areaCode);
	}
	
	/**
	 * 新增区域
	 * @param area
	 * @return
	 */
	@SysLog("新增区域")
	@RequestMapping("/save")
	public Result save(@RequestBody SysAreaEntity area) {
		boolean  count = sysAreaService.save(area);
		return ResultKit.msg(count);
	}
	
	/**
	 * 查询详情
	 * @param areaId
	 * @return
	 */
	@RequestMapping("/info")
	public Result info(@RequestBody Integer areaId) {
		SysAreaEntity area = sysAreaService.getById(areaId);
		return ResultKit.msg(area);
	}
	
	/**
	 * 修改区域
	 * @param area
	 * @return
	 */
	@SysLog("修改区域")
	@RequestMapping("/update")
	public Result update(@RequestBody SysAreaEntity area) {
		boolean count = sysAreaService.update(area);
		return ResultKit.msg(count);
	}
	
	/**
	 * 删除区域
	 * @param ids
	 * @return
	 */
	@SysLog("删除区域")
	@RequestMapping("/remove")
	public Result remove(@RequestBody Integer[] ids) {
		try {
			boolean count = sysAreaService.removeByIds(ids);
			return ResultKit.msg(count);
		} catch (RmsException e) {
			log.error("", e);
			return Result.error(e.getMsg());
		}
	}
	
}
