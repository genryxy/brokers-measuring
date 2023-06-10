package ru.hse.babds.common;

import lombok.Getter;

@Getter
public enum DataSize {
    KB_1(1000),
    KB_10(500),
    KB_100(100),
    MB_1(50),
    MB_10(10);

    private final int printEach;

    DataSize(int printEach) {
        this.printEach = printEach;
    }
}
