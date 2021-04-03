package com.powerdevs.vetsapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigProperties {
    private static String key;

    @Autowired
    public ConfigProperties(@Value("${api.key}") String key) {
        ConfigProperties.key = key;
    }

    public static String getApiKey() {
        return key;
    }
}
