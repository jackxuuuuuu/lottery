CREATE DATABASE IF NOT EXISTS lottery DEFAULT CHARACTER SET utf8mb4;

USE lottery;

CREATE TABLE IF NOT EXISTS lottery_records (
    id         BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ip         VARCHAR(45)  NOT NULL COMMENT '客户端 IP',
    prize      VARCHAR(64)  NOT NULL COMMENT '奖项名称',
    created_at BIGINT       NOT NULL COMMENT '抽奖时间戳（毫秒）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
