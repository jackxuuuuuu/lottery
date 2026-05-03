package com.lottery.repository;

import com.lottery.model.LotteryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotteryRecordRepository extends JpaRepository<LotteryRecord, Long> {
}
