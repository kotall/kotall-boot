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
import com.kotall.rms.common.entity.litemall.LiteMallFeedbackEntity;
import com.kotall.rms.core.service.litemall.LiteMallFeedbackService;

/**
 * 意见反馈表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:33:08
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/feedback")
public class LiteMallFeedbackController extends AbstractController {
	
	@Autowired
	private LiteMallFeedbackService liteMallFeedbackService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallFeedbackEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallFeedbackService.queryFeedbackByPage(params);
	}
		
	/**
	 * 新增
	 * @param liteMallFeedback
	 * @return
	 */
	@SysLog("新增意见反馈表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallFeedbackEntity liteMallFeedback) {
	    boolean count = liteMallFeedbackService.save(liteMallFeedback);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Integer id) {
		LiteMallFeedbackEntity liteMallFeedback = liteMallFeedbackService.getById(id);
		return ResultKit.msg(liteMallFeedback);
	}
	
	/**
	 * 修改
	 * @param liteMallFeedback
	 * @return
	 */
	@SysLog("修改意见反馈表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallFeedbackEntity liteMallFeedback) {
		boolean count = liteMallFeedbackService.update(liteMallFeedback);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除意见反馈表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Integer[] id) {
		boolean count = liteMallFeedbackService.deleteByIds(id);
		return ResultKit.msg(count);
	}
	
}
