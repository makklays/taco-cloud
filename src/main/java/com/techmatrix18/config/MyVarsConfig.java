package com.techmatrix18.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "myvars")
public class MyVarsConfig {

    /**
     * My number variable
     */
    private int mynumber;

    public int getMynumber() {
        return mynumber;
    }

    public void setMynumber(int mynumber) {
        this.mynumber = mynumber;
    }
}

