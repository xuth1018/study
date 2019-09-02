package com.example.demo.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component("my2")
public class MyAbstractHealthIndicator extends AbstractHealthIndicator {
    public static final String VERSION = "v1..0.0";

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        int code = check();
        if(code!=0){
            builder.down().withDetail("code",code).withDetail("version",VERSION).build();
        }
        builder.up().withDetail("code",code).withDetail("version",VERSION).up().build();
    }


    private int check() {
        return 0;
    }
}