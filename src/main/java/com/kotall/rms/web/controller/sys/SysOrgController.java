package com.kotall.rms.web.controller.sys;

import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.constants.Constant;
import com.kotall.rms.web.util.ResultKit;
import com.kotall.rms.common.entity.sys.SysOrgEntity;
import com.kotall.rms.core.service.sys.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 组织机构
 *
 * @author aracwong
 * @date 2017年8月17日 上午11:35:00
 * @since 1.0.0
 */
@RestController
@RequestMapping("/sys/org")
public class SysOrgController extends AbstractController {

	@Autowired
	private SysOrgService sysOrgService;
	
	/**
	 * 机构列表
	 * 根据用户所属的机构查询下级机构列表
	 * 方法一： 用户点击子机构列表的时候去后台查询
	 * 方法二： 一次性查询所有机构，应用中计算属性关系， 目前采用这种方法
	 * @return
	 */
	@RequestMapping("/list")
	public List<SysOrgEntity> list() {
		List<SysOrgEntity> sysOrgList = this.sysOrgService.queryByList(new HashMap<>());
		return sysOrgList;
	}
	
	/**
	 * 树形机构列表，机构新增、编辑
	 * @return
	 */
	@RequestMapping("/select")
	public List<SysOrgEntity> select() {
		List<SysOrgEntity> sysOrgList = this.sysOrgService.queryByList(new HashMap<String, Object>());
		// 添加一级部门
		if(super.getUserId() == Constant.SUPER_ADMIN){
			SysOrgEntity root = new SysOrgEntity();
			root.setOrgId(0);
			root.setName("一级部门");
			root.setParentId(-1);
			root.setOpen(true);
			sysOrgList.add(root);
		}
		return sysOrgList;
	}
	
	/**
	 * 新增机构
	 * @param org
	 * @return
	 */
	@SysLog("新增机构")
	@RequestMapping("/save")
	public Result save(@RequestBody SysOrgEntity org) {
		boolean count = sysOrgService.save(org);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询机构详情
	 * @param orgId
	 * @return
	 */
	@RequestMapping("/info")
	public Result info(@RequestBody Integer orgId) {
		SysOrgEntity org = sysOrgService.getById(orgId);
		return ResultKit.msg(org);
	}

	/**
	 * 查询根机构号
	 * @return
	 */
	@RequestMapping("/rootInfo")
	public Result rootInfo() {
		long deptId = 0;
		if(getUserId() != Constant.SUPER_ADMIN){
			List<SysOrgEntity> deptList = sysOrgService.queryByList(new HashMap<>());
			Integer parentId = null;
			for(SysOrgEntity sysDeptEntity : deptList){
				if(parentId == null){
					parentId = sysDeptEntity.getParentId();
					continue;
				}

				if(parentId > sysDeptEntity.getParentId().longValue()){
					parentId = sysDeptEntity.getParentId();
				}
			}
			deptId = parentId;
		}

		return Result.ok().put("orgId", deptId);
	}
	
	/**
	 * 修改机构
	 * @param org
	 * @return
	 */
	@SysLog("修改机构")
	@RequestMapping("/update")
	public Result update(@RequestBody SysOrgEntity org) {
		boolean count = sysOrgService.update(org);
		return ResultKit.msg(count);
	}
	
	/**
	 * 删除机构
	 * @param id
	 * @return
	 */
	@SysLog("删除机构")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Integer[] id) {
		int count = sysOrgService.batchRemoveOrg(id);
		return ResultKit.msg(id, count);
	}
	
}
