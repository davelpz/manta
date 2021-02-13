package dev.davelpz.manta;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class PixelStreamTest {

    @Test
    void genStream() {
        AtomicInteger count= new AtomicInteger();
        PixelStream.genStream(10,10).forEach(p -> {
            System.out.println(p);
            count.getAndIncrement();
        });
        assertEquals(100, count.get());
    }
}