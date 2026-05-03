package com.lottery.model;

import javax.persistence.*;

@Entity
@Table(name = "lottery_records")
public class LotteryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ip;
    private String prize;

    @Column(name = "created_at")
    private long createdAt;

    public LotteryRecord() {}

    public LotteryRecord(String ip, String prize, long createdAt) {
        this.ip = ip;
        this.prize = prize;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getIp() { return ip; }
    public String getPrize() { return prize; }
    public long getCreatedAt() { return createdAt; }
}
