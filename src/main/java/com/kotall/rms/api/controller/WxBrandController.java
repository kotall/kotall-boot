package com.kotall.rms.api.controller;

import com.kotall.rms.common.entity.litemall.LiteMallBrandEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx/brand")
@Validated
@Slf4j
public class WxBrandController {

    @Autowired
    private LiteMallBrandService brandService;

    /**
     * 品牌列表
     *
     * @param page 分页页数
     * @param size 分页大小
     * @return 品牌列表
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data:
     * {
     * brandList: xxx,
     * totalPages: xxx
     * }
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("list")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size) {

        Map<String, Object> params = new HashMap<>();
        params.put("deleted", 0);
        params.put("pageNumber", page);
        params.put("pageSize", size);
        Page<LiteMallBrandEntity> pages = brandService.queryByPage(params);

        Map<String, Object> data = new HashMap<>();
        data.put("brandList", pages.getRows());
        data.put("totalPages", pages.getTotalPages());
        return Result.ok().put("data", data);
    }

    /**
     * 品牌详情
     *
     * @param id 品牌ID
     * @return 品牌详情
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data:
     * {
     * brand: xxx
     * }
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("detail")
    public Object detail(@NotNull Integer id) {
        LiteMallBrandEntity entity = brandService.getById(id);
        if (entity == null) {
            return Result.badArgumentValue();
        }

        Map<String, Object> data = new HashMap<>();
        data.put("brand", entity);
        return Result.ok().put("data", data);
    }
}