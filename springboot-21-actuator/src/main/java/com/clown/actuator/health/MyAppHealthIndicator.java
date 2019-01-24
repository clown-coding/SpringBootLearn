package com.clown.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/24
 **/
@Component
public class MyAppHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        //自定义检查方法
        //return Health.up().build(); //健康

        return Health.down().withDetail("msg","服务异常").build(); //服务异常
    }
}
