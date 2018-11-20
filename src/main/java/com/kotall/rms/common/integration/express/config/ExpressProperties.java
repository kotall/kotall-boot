package com.kotall.rms.common.integration.express.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Data
@ToString
@ConfigurationProperties(prefix = "litemall.express")
public class ExpressProperties {
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    private String appId;
    private String appKey;

    private List<Map<String, String>> vendors = new ArrayList<>();

    public List<Map<String, String>> getVendors() {
        return vendors;
    }

}
