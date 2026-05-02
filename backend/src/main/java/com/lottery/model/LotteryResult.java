package com.lottery.model;

public class LotteryResult {
    private int code;
    private String prize;
    private String message;
    private long timestamp;

    public LotteryResult(int code, String prize, String message) {
        this.code = code;
        this.prize = prize;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public int getCode() { return code; }
    public String getPrize() { return prize; }
    public String getMessage() { return message; }
    public long getTimestamp() { return timestamp; }
}
