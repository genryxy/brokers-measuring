package ru.hse.babds.common.utils;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import ru.hse.babds.common.DataSize;

@Slf4j
public class MeasureLogs {
    public static void produceToLog(AtomicInteger counter, DataSize dataSize) {
        if (counter.incrementAndGet() % dataSize.getPrintEach() == 0) {
            log.info("Sent '{}' messages", counter.get());
        }
    }

    public static void consumeToLog(AtomicInteger counter, DataSize dataSize) {
        if (counter.incrementAndGet() % dataSize.getPrintEach() == 0) {
            log.info("Processed '{}' messages", counter.get());
        }
    }
}
