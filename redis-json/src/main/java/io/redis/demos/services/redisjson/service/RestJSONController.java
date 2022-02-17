package io.redis.demos.services.redisjson.service;

import io.redis.demos.services.redisjson.domain.Mojies;
import io.redis.demos.services.redisjson.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.*;
import redis.clients.jedis.json.Path;
import redis.clients.jedis.providers.PooledConnectionProvider;

import javax.annotation.PostConstruct;

@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/api/1.0/redis-service-json/")
@RestController
public class RestJSONController {

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private int redisPort;

    @Value("${redis.password}")
    private String redisPassword;

    private UnifiedJedis jedis;

    @PostConstruct
    private void init() {

        log.info("Create Jedis Pool with {}:{} ", redisHost, redisPort);
        if (redisPassword != null && redisPassword.trim().isEmpty()) {
            redisPassword = null;
        }
        HostAndPort config = new HostAndPort(redisHost, redisPort);
        PooledConnectionProvider provider = new PooledConnectionProvider(config);//TODO password
        jedis = new UnifiedJedis(provider);
    }

    @GetMapping("/load")
    public Object load() {
        for (int i = 0; i < 200; i++) {
            Mojies m = Mojies.of(
                    "Java et Redis sont sur un bateau - episode " + i,
                    2022 + ((int) i / 2),
                    "Action",
                    "Java + JSON + Redis <3"
            );
            m.setPoster("https://developer.redis.com/howtos/redisjson/using-java/");
            m.setRating(9.0);
            m.setVotes(999);

            jedis.jsonSetWithEscape("json:mojies:" + i, m);
        }
        return jedis.jsonGet("json:mojies:10", Path.of("$.title"));
    }

    @GetMapping("/movies/{id}")
    public Object movies(@PathVariable("id") String id) {
        return jedis.jsonGet("json:mojies:" + id);
    }
}