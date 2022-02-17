package io.redis.demos.services.redisom.service;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@EnableRedisDocumentRepositories(basePackages = "io.redis.demos.services.redisom.*")
public class RedisOMApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisOMApplication.class, args);
    }


}
