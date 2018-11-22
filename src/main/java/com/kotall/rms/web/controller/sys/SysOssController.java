package com.kotall.rms.web.controller.sys;

import com.kotall.rms.common.entity.sys.SysOssEntity;
import com.kotall.rms.common.integration.cloud.OSSFactory;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.core.constants.ConfigConstant;
import com.kotall.rms.core.service.sys.SysConfigService;
import com.kotall.rms.core.service.sys.SysOssService;
import com.kotall.rms.web.util.ResultKit;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

/**
 * 文件上传
 *
 * @author kotall
 * @date 2018年11月12日 下午10:28:34
 * @since 1.0.0
 */
@RestController
@RequestMapping("/sys/oss")
public class SysOssController extends AbstractController {
	
	@Autowired
	private SysOssService sysOssService;
	@Autowired
	private SysConfigService sysConfigService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SysOssEntity> list(@RequestBody Map<String, Object> params) {
		return sysOssService.listSysOss(params);
	}
		
	/**
	 * 新增
	 * @param sysOss
	 * @return
	 */
	@SysLog("新增文件上传")
	@RequestMapping("/save")
	public Result save(@RequestBody SysOssEntity sysOss) {
	    int count = sysOssService.saveSysOss(sysOss);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		SysOssEntity sysOss = sysOssService.getSysOssById(id);
		return ResultKit.msg(sysOss);
	}
	
	/**
	 * 修改
	 * @param sysOss
	 * @return
	 */
	@SysLog("修改文件上传")
	@RequestMapping("/update")
	public Result update(@RequestBody SysOssEntity sysOss) {
        int count = sysOssService.updateSysOss(sysOss);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除文件上传")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		//TODO 先删除OSS中的文件
	    int count = sysOssService.batchRemove(id);
		return ResultKit.msg(count);
	}

	/**
	 * 上传文件
	 */
	@RequestMapping("/upload")
	@RequiresPermissions("sys:oss:upload")
	public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			throw new RmsException("上传文件不能为空");
		}

		// 上传文件
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String cloudStorageConfigKey = this.sysConfigService.getValue(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY);
		String url = OSSFactory.build(cloudStorageConfigKey).uploadSuffix(file.getBytes(), suffix);

		// 保存文件信息
		SysOssEntity ossEntity = new SysOssEntity();
		ossEntity.setName(file.getOriginalFilename());
		ossEntity.setSize((int) file.getSize());
		ossEntity.setType(file.getContentType());
		ossEntity.setKey(null);
		ossEntity.setUrl(url);
		ossEntity.setCreateTime(new Date());
		sysOssService.saveSysOss(ossEntity);

		return Result.ok().put("url", url);
	}
	
}
