package com.kotall.rms.api.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品api
 * @author zpwang
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @GetMapping("/list")
    public String list() {
        return "goods list";
    }
}
