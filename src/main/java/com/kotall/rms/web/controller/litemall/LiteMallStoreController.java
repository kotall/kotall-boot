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
import com.kotall.rms.common.entity.litemall.LiteMallStoreEntity;
import com.kotall.rms.core.service.litemall.LiteMallStoreService;

/**
 * 店铺表 
 *
 * @author kotall
 * @date 2018年11月14日 下午6:05:16
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/store")
public class LiteMallStoreController extends AbstractController {
	
	@Autowired
	private LiteMallStoreService liteMallStoreService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallStoreEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallStoreService.listLiteMallStore(params);
	}
		
	/**
	 * 新增
	 * @param liteMallStore
	 * @return
	 */
	@SysLog("新增店铺表 ")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallStoreEntity liteMallStore) {
		liteMallStore.setUserId(super.getUserId());
	    int count = liteMallStoreService.saveLiteMallStore(liteMallStore);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		LiteMallStoreEntity liteMallStore = liteMallStoreService.getLiteMallStoreById(id);
		return ResultKit.msg(liteMallStore);
	}
	
	/**
	 * 修改
	 * @param liteMallStore
	 * @return
	 */
	@SysLog("修改店铺表 ")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallStoreEntity liteMallStore) {
        int count = liteMallStoreService.updateLiteMallStore(liteMallStore);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除店铺表 ")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
	    int count = liteMallStoreService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
}
