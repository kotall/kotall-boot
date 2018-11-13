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
import com.kotall.rms.common.entity.litemall.LiteMallIssueEntity;
import com.kotall.rms.core.service.litemall.LiteMallIssueService;

/**
 * 常见问题表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:29:37
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/issue")
public class LiteMallIssueController extends AbstractController {
	
	@Autowired
	private LiteMallIssueService liteMallIssueService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallIssueEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallIssueService.listLiteMallIssue(params);
	}
		
	/**
	 * 新增
	 * @param liteMallIssue
	 * @return
	 */
	@SysLog("新增常见问题表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallIssueEntity liteMallIssue) {
	    int count = liteMallIssueService.saveLiteMallIssue(liteMallIssue);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallIssueEntity liteMallIssue = liteMallIssueService.getLiteMallIssueById(id);
		return ResultKit.msg(liteMallIssue);
	}
	
	/**
	 * 修改
	 * @param liteMallIssue
	 * @return
	 */
	@SysLog("修改常见问题表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallIssueEntity liteMallIssue) {
        int count = liteMallIssueService.updateLiteMallIssue(liteMallIssue);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除常见问题表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallIssueService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
