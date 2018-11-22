package com.kotall.rms.core.config;

import com.kotall.rms.api.annotation.support.AppConfigHandlerMethodArgumentResolver;
import com.kotall.rms.core.service.litemall.LiteMallAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class ApiConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private LiteMallAppService appService;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new AppConfigHandlerMethodArgumentResolver(this.appService));
    }


}
