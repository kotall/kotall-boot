package com.kotall.rms.api.vo;

import com.kotall.rms.common.entity.litemall.LiteMallBrandEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class BrandVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 品牌商名称
     */
    private String name;

    /**
     * 品牌商简介
     */
    private String desc;

    /**
     * 品牌商的商品图片
     */
    private String picUrl;

    /**
     * 品牌商商品底价
     */
    private String floorPrice;

    public static BrandVO fromBrandEntity(LiteMallBrandEntity entity) {
        BrandVO vo = new BrandVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    public static List<BrandVO> fromBrandEntity(List<LiteMallBrandEntity> entitys) {
        List<BrandVO> voList = new ArrayList<>();
        for (LiteMallBrandEntity entity : entitys) {
            BrandVO vo = new BrandVO();
            BeanUtils.copyProperties(entity, vo);
            voList.add(vo);
        }

        return voList;
    }

}
