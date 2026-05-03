package com.lottery.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Populates the lottery prize options into Redis on startup (only if the key is absent).
 * Each entry is stored as "prizeName|message" in the list key "lottery:prizes".
 */
@Component
public class RedisInitializer implements ApplicationRunner {

    public static final String PRIZES_KEY = "lottery:prizes";

    private static final String[] DEFAULT_PRIZES = {
        // Format: "prizeName|message"
        "一等奖|恭喜你抽中了一等奖！",
        "二等奖|恭喜你抽中了二等奖！",
        "三等奖|恭喜你抽中了三等奖！",
        "谢谢参与|感谢参与，下次再来吧！"
    };

    private final StringRedisTemplate redisTemplate;

    public RedisInitializer(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void run(ApplicationArguments args) {
        Boolean exists = redisTemplate.hasKey(PRIZES_KEY);
        if (Boolean.TRUE.equals(exists)) {
            return;
        }
        for (String prize : DEFAULT_PRIZES) {
            redisTemplate.opsForList().rightPush(PRIZES_KEY, prize);
        }
    }
}
