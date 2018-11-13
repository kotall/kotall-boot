package com.kotall.rms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpwang
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @GetMapping("/list/{mid}")
    public String list(@PathVariable("mid") String userId) {
        return "order list";
    }
}
