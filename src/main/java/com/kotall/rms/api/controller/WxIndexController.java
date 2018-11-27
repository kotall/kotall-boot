package com.kotall.rms.api.controller;

import com.kotall.rms.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/index")
@Slf4j
public class WxIndexController {

    @RequestMapping("/index")
    public Object index(){
        return Result.ok("hello world, this is wx service");
    }

}