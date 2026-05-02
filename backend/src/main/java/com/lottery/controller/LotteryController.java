package com.lottery.controller;

import com.lottery.model.LotteryResult;
import com.lottery.service.LotteryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lottery")
@CrossOrigin(origins = "*")
public class LotteryController {

    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("/draw")
    public LotteryResult draw() {
        return lotteryService.draw();
    }
}
