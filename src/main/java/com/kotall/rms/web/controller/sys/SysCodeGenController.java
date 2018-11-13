package com.kotall.rms.web.controller.sys;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysGenColumnEntity;
import com.kotall.rms.common.entity.sys.SysGenParamEntity;
import com.kotall.rms.common.entity.sys.SysGenTableEntity;
import com.kotall.rms.core.service.sys.SysCodeGenService;
import com.kotall.rms.core.GenUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器
 *
 * @author aracwong
 * @date 2017年8月28日 下午8:56:30
 */
@Controller
@RequestMapping("/sys/gen")
public class SysCodeGenController {

	@Autowired
	private SysCodeGenService sysCodeGenService;
	
	/**
	 * 表格列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Page<SysGenTableEntity> list(@RequestBody Map<String, Object> params) {
		return sysCodeGenService.listTable(params);
	}
	
	/**
	 * 生成代码
	 * @param params
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/code")
	public void generator(SysGenParamEntity params, HttpServletRequest request, HttpServletResponse response) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(out);
		for(String table : params.getTables()) {
			SysGenTableEntity sysGenTableEntity = sysCodeGenService.getTableByName(table);
			List<SysGenColumnEntity> columns = sysCodeGenService.listColumn(table);
			GenUtils.generatorCode(sysGenTableEntity, columns, params, zip);
		}

		IOUtils.closeQuietly(zip);
		byte[] code = out.toByteArray();

		String attachment = "attachment; filename=" + params.getTables()[0] + ".zip";
		response.reset();
        response.setHeader("Content-Disposition", attachment);
        response.addHeader("Content-Length", "" + code.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(code, response.getOutputStream());
	}
	
}
