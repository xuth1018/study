package com.example.demo.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("myl")
public class MyHealthIndicator implements HealthIndicator {
    public static final String VERSION = "v1.0.0";
    @Override
    public Health health() {
        int code = check();
        if (code != 0) {
            Health.down().withDetail("code",code).withDetail("version",VERSION).build();
        }
        return Health.up().withDetail("code",code).withDetail("version",VERSION).up().build();
    }
    private int check(){
        return 0;
    }
}
