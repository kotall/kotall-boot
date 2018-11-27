package com.kotall.rms.api.controller;

import com.kotall.rms.common.entity.sys.SysAreaEntity;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.sys.SysAreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/wx/region")
@Validated
@Slf4j
public class WxRegionController {

    @Autowired
    private SysAreaService regionService;

    /**
     * 区域数据
     *
     * 根据父区域ID，返回子区域数据。
     * 如果父区域ID是0，则返回省级区域数据；
     *
     * @param areaCode 父区域ID
     * @return 区域数据
     *   成功则
     *  {
     *      code: 0,
     *      msg: '成功',
     *      data: xxx
     *  }
     *   失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("list")
    public Object list(@NotNull String areaCode) {
        List<SysAreaEntity> regionList = regionService.listAreaByParentCode(areaCode);
        return Result.ok().put("data", regionList);
    }
}