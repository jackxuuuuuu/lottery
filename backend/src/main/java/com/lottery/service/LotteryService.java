package com.lottery.service;

import com.lottery.model.LotteryResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class LotteryService {

    private static final String[][] PRIZES = {
        {"一等奖", "恭喜你抽中了一等奖！"},
        {"二等奖", "恭喜你抽中了二等奖！"},
        {"三等奖", "恭喜你抽中了三等奖！"},
        {"谢谢参与", "感谢参与，下次再来吧！"}
    };

    public LotteryResult draw() {
        int index = ThreadLocalRandom.current().nextInt(PRIZES.length);
        return new LotteryResult(0, PRIZES[index][0], PRIZES[index][1]);
    }
}
