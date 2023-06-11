package ru.hse.babds.common;

import lombok.Getter;

@Getter
public enum DataSize {
    KB_1(1000),
    KAFKA_KB_1(10000),
    KB_10(500),
    KAFKA_KB_10(5000),
    KB_100(100),
    KAFKA_KB_100(1000),
    MB_1(50),
    KAFKA_MB_1(200),
    MB_10(10),
    KAFKA_MB_10(50);

    private final int printEach;

    DataSize(int printEach) {
        this.printEach = printEach;
    }
}
