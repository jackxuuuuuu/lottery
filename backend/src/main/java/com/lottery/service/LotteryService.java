package com.lottery.service;

import com.lottery.config.RedisInitializer;
import com.lottery.model.ApiResponse;
import com.lottery.model.LotteryRecord;
import com.lottery.model.LotteryResult;
import com.lottery.repository.LotteryRecordRepository;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class LotteryService {

    private final StringRedisTemplate redisTemplate;
    private final LotteryRecordRepository recordRepository;

    public LotteryService(StringRedisTemplate redisTemplate,
                          LotteryRecordRepository recordRepository) {
        this.redisTemplate = redisTemplate;
        this.recordRepository = recordRepository;
    }

    public ApiResponse<LotteryResult> draw(String ip) {
        List<String> prizes = redisTemplate.opsForList().range(RedisInitializer.PRIZES_KEY, 0, -1);
        if (prizes == null || prizes.isEmpty()) {
            return ApiResponse.error(-1, "奖项未配置，请联系管理员");
        }

        // Each Redis entry has the format "prizeName|message"
        int index = ThreadLocalRandom.current().nextInt(prizes.size());
        String[] parts = prizes.get(index).split("\\|", 2);
        String prizeName = parts[0];
        String message = parts.length > 1 ? parts[1] : "";

        long now = System.currentTimeMillis();
        recordRepository.save(new LotteryRecord(ip, prizeName, now));

        return ApiResponse.success(new LotteryResult(prizeName, message));
    }
}
