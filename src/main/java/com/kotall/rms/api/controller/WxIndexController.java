package com.kotall.rms.api.controller;

import com.kotall.rms.common.utils.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/index")
public class WxIndexController {
    private final Log logger = LogFactory.getLog(WxIndexController.class);

    @RequestMapping("/index")
    public Object index(){
        return Result.ok("hello world, this is wx service");
    }

}