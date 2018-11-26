package com.kotall.rms.api.controller;

import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.api.vo.AddressVO;
import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.utils.RegexUtil;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallAddressService;
import com.kotall.rms.core.service.sys.SysAreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wx/address")
@Validated
@Slf4j
public class WxAddressController {

    @Autowired
    private LiteMallAddressService addressService;
    @Autowired
    private SysAreaService regionService;

    /**
     * 用户收货地址列表
     *
     * @param userId 用户ID
     * @return 收货地址列表
     *   成功则
     *  {
     *      code: 0,
     *      msg: '成功',
     *      data: xxx
     *  }
     *   失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("list")
    public Object list(@LoginUser Integer userId) {
        if(userId == null){
            return Result.unLogin();
        }
        List<LiteMallAddressEntity> addressList = addressService.queryByUserId(userId);
        List<AddressVO> addressVoList = new ArrayList<>(addressList.size());
        for(LiteMallAddressEntity address : addressList){
            AddressVO addressVo = new AddressVO();
            addressVo.setId(address.getId());
            addressVo.setName(address.getName());
            addressVo.setMobile(address.getMobile());
            addressVo.setIsDefault(address.getIsDefault());
            String provinceName = regionService.getByAreaCode(address.getProvinceId()).getName();
            String cityName = regionService.getByAreaCode(address.getCityId()).getName();
            String areaName = regionService.getByAreaCode(address.getAreaId()).getName();
            String detailAddress = provinceName.concat(cityName).concat(areaName).concat(" ").concat(address.getAddress());
            addressVo.setAddress(detailAddress);
            addressVoList.add(addressVo);
        }
        return Result.ok().put("data", addressVoList);
    }

    /**
     * 收货地址详情
     *
     * @param userId 用户ID
     * @param id 收获地址ID
     * @return 收货地址详情
     *   成功则
     *  {
     *      code: 0,
     *      msg: '成功',
     *      data:
     *        {
     *           id: xxx,
     *           name: xxx,
     *           provinceId: xxx,
     *           cityId: xxx,
     *           areaId: xxx,
     *           mobile: xxx,
     *           address: xxx,
     *           isDefault: xxx,
     *           version: xxx
     *           provinceName: xxx,
     *           cityName: xxx,
     *           areaName: xxx
     *        }
     *  }
     *   失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("detail")
    public Object detail(@LoginUser Integer userId, @NotNull Integer id) {

        if(userId == null){
            return Result.unLogin();
        }

        LiteMallAddressEntity address = addressService.getById(id);
        if(address == null){
            return Result.badArgumentValue();
        }

        AddressVO data = new AddressVO();
        data.setId(address.getId());
        data.setName(address.getName());
        data.setProvinceId(address.getProvinceId());
        data.setCityId(address.getCityId());
        data.setAreaId(address.getAreaId());
        data.setMobile(address.getMobile());
        data.setAddress(address.getAddress());
        data.setIsDefault(address.getIsDefault());
        String provinceName = regionService.getByAreaCode(address.getProvinceId()).getName();
        data.setProvinceName(provinceName);
        String cityName = regionService.getByAreaCode(address.getCityId()).getName();
        data.setCityName(cityName);
        String areaName = regionService.getByAreaCode(address.getAreaId()).getName();
        data.setAreaName(areaName);
        return Result.ok().put("data", data);
    }

    private Object validate(AddressVO address) {
        String name = address.getName();
        if(StringUtils.isEmpty(name)){
            return Result.badArgument();
        }

        // 测试收货手机号码是否正确
        String mobile = address.getMobile();
        if(StringUtils.isEmpty(mobile)){
            return Result.badArgument();
        }
        if(!RegexUtil.isMobileExact(mobile)){
            return Result.badArgument();
        }

        Integer pid = address.getProvinceId();
        if(pid == null){
            return Result.badArgument();
        }
        if(regionService.getByAreaCode(pid) == null){
            return Result.badArgumentValue();
        }

        Integer cid = address.getCityId();
        if(cid == null){
            return Result.badArgument();
        }
        if(regionService.getByAreaCode(cid) == null){
            return Result.badArgumentValue();
        }

        Integer aid = address.getAreaId();
        if(aid == null){
            return Result.badArgument();
        }
        if(regionService.getByAreaCode(aid) == null){
            return Result.badArgumentValue();
        }

        String detailedAddress = address.getAddress();
        if(StringUtils.isEmpty(detailedAddress)){
            return Result.badArgument();
        }

        Boolean isDefault = address.getIsDefault();
        if(isDefault == null){
            return Result.badArgument();
        }
        return null;
    }

    /**
     * 添加或更新收货地址
     *
     * @param userId 用户ID
     * @param address 用户收货地址
     * @return 添加或更新操作结果
     *   成功则 { code: 0, msg: '成功' }
     *   失败则 { code: XXX, msg: XXX }
     */
    @PostMapping("save")
    public Object save(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig, @RequestBody AddressVO address) {
        if(userId == null){
            return Result.unLogin();
        }
        Object error = validate(address);
        if(error != null){
            return error;
        }

        if(address.getIsDefault()){
            // 重置其他收获地址的默认选项
            addressService.resetDefault(userId);
        }

        Integer addressId = null;
        if (address.getId() == null || address.getId().equals(0)) {
            address.setId(null);
            address.setStoreId(appConfig.getStoreId());
            address.setUserId(userId);
            LiteMallAddressEntity entity = address.convertToEntity();
            addressService.save(entity);
            addressId = entity.getId();
        } else {
            address.setUserId(userId);
            if(addressService.update(address.convertToEntity())){
                return Result.updatedDataFailed();
            }
        }
        return Result.ok().put("data", addressId);
    }

    /**
     * 删除收货地址
     *
     * @param userId 用户ID
     * @param address 用户收货地址
     * @return 删除结果
     *   成功则 { code: 0, msg: '成功' }
     *   失败则 { code: XXX, msg: XXX }
     */
    @PostMapping("delete")
    public Object delete(@LoginUser Integer userId, @RequestBody LiteMallAddressEntity address) {
        if(userId == null){
            return Result.unLogin();
        }
        Integer id = address.getId();
        if(id == null){
            return Result.badArgument();
        }

        addressService.deleteByIds(new Integer[]{id});
        return Result.ok();
    }
}