package com.kotall.rms.web.controller.litemall;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.kotall.rms.common.integration.storage.StorageService;
import com.kotall.rms.common.utils.FileKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.web.controller.sys.AbstractController;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
        import com.kotall.rms.web.util.ResultKit;
import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.core.service.litemall.LiteMallStorageService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 上午11:42:26
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/storage")
public class LiteMallStorageController extends AbstractController {
	
	@Autowired
	private LiteMallStorageService liteMallStorageService;
	@Autowired
	private StorageService storageService;

	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LiteMallStorageEntity> list(@RequestBody Map<String, Object> params) {
		return liteMallStorageService.queryByPage(params);
	}
		
	/**
	 * 新增
	 * @param liteMallStorage
	 * @return
	 */
	@SysLog("新增文件存储表")
	@RequestMapping("/save")
	public Result save(@RequestBody LiteMallStorageEntity liteMallStorage) {
		boolean count = liteMallStorageService.save(liteMallStorage);
		return ResultKit.msg(count);
	}


	@PostMapping("/create")
	public Object create(@RequestParam("file") MultipartFile file) throws IOException {
		String originalFilename = file.getOriginalFilename();
		String url = storageService.store(file.getInputStream(), file.getSize(), file.getContentType(), storageService.getActive(), FileKit.getFileSufix(originalFilename));

		LiteMallStorageEntity storageInfo = new LiteMallStorageEntity();
		storageInfo.setName(originalFilename);
		storageInfo.setSize((int) file.getSize());
		storageInfo.setType(file.getContentType());
		storageInfo.setKey(UUID.randomUUID().toString());
		storageInfo.setUrl(url);
		storageInfo.setStoreId(1); // TODO
		liteMallStorageService.save(storageInfo);

		Map<String, Object> data = new HashMap<>();
		data.put("url", url);
		return ResultKit.msg(data);
	}

	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Integer id) {
		LiteMallStorageEntity liteMallStorage = liteMallStorageService.getById(id);
		return ResultKit.msg(liteMallStorage);
	}
	
	/**
	 * 修改
	 * @param liteMallStorage
	 * @return
	 */
	@SysLog("修改文件存储表")
	@RequestMapping("/update")
	public Result update(@RequestBody LiteMallStorageEntity liteMallStorage) {
		boolean count = liteMallStorageService.update(liteMallStorage);
		return  ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除文件存储表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Integer[] id) {
		boolean count = liteMallStorageService.deleteByIds(id);
		return ResultKit.msg(count);
	}
	
}
