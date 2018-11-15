package com.kotall.rms.web.controller.sys;

import java.util.List;
import java.util.Map;

import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.web.util.ResultKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysRoleEntity;
import com.kotall.rms.core.service.sys.SysRoleService;

/**
 * 系统角色
 *
 * @author aracwong
 * @date 2017年8月12日 上午12:43:10
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {

	@Autowired
	private SysRoleService sysRoleService;
	
	/**
	 * 角色列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SysRoleEntity> list(@RequestBody Map<String, Object> params) {
		params.put("userId", getUserId());
		return sysRoleService.listRole(params);
	}
	
	/**
	 * 用户角色
	 * @return
	 */
	@RequestMapping("/select")
	public Result listRole() {
		List<SysRoleEntity> roleList = sysRoleService.listRole();
		return ResultKit.msgNotCheckNull(roleList);
	}
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	@SysLog("新增角色")
	@RequestMapping("/save")
	public Result saveRole(@RequestBody SysRoleEntity role) {
		role.setUserIdCreate(getUserId());
		int count = sysRoleService.saveRole(role);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getRoleById(@RequestBody Long id) {
		SysRoleEntity role = sysRoleService.getRoleById(id);
		return ResultKit.msg(role);
	}
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@SysLog("修改角色")
	@RequestMapping("/update")
	public Result updateRole(@RequestBody SysRoleEntity role) {
		int count = sysRoleService.updateRole(role);
		return ResultKit.msg(count);
	}
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	@SysLog("删除角色")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		int count = sysRoleService.batchRemove(id);
		return ResultKit.msg(id, count);
	}
	
	/**
	 * 分配权限
	 * @param role
	 * @return
	 */
	@SysLog("操作权限")
	@RequestMapping("/authorize/opt")
	public Result updateRoleOptAuthorization(@RequestBody SysRoleEntity role) {
		int count = sysRoleService.updateRoleOptAuthorization(role);
		return ResultKit.msg(count);
	}
	
	/**
	 * 数据权限
	 * @param role
	 * @return
	 */
	@SysLog("数据权限")
	@RequestMapping("/authorize/data")
	public Result updateRoleDataAuthorization(@RequestBody SysRoleEntity role) {
		int count = sysRoleService.updateRoleDataAuthorization(role);
		return ResultKit.msg(count);
	}
	
}
