package com.lottery.model;

public class LotteryResult {
    private String prize;
    private String message;

    public LotteryResult(String prize, String message) {
        this.prize = prize;
        this.message = message;
    }

    public String getPrize() { return prize; }
    public String getMessage() { return message; }
}
