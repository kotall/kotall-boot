package com.kotall.rms.api.annotation.support;

import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.core.service.litemall.LiteMallAppService;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class AppConfigHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public static final String SID = "sid";

    private LiteMallAppService appService;

    public AppConfigHandlerMethodArgumentResolver(LiteMallAppService appService) {
        super();
        this.appService = appService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(LiteMallAppEntity.class) && parameter.hasParameterAnnotation(AppConfig.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {

        String appId = request.getParameter(SID);
        if(appId == null || appId.isEmpty()){
            return null;
        }

        return this.appService.getByAppId(appId);
    }
}
