package com.kotall.rms.web.controller.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallGoodsSpecificationService;
import com.kotall.rms.web.util.ResultKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品规格
 *
 * @author kotall
 * @date 2018年11月19日 下午3:03:30
 * @since 1.0.0
 */
@RestController
@RequestMapping("/litemall/specification")
public class LiteMallGoodsSpecificationController {

    @Autowired
    private LiteMallGoodsSpecificationService liteMallGoodsSpecificationService;

    /**
     * 列表
     * @return
     */
    @RequestMapping("/getByGoodsId")
    public Result getByGoodsId(String goodsId) {
        return ResultKit.msg(liteMallGoodsSpecificationService.getByGoodsId(goodsId));
    }
}
