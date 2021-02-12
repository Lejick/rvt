package com.revolut.url;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementUrlGenerator implements ShortUrlGenerator {
    private AtomicInteger index = new AtomicInteger(0);

    @Override
    public String generate() {
        return String.valueOf(index.incrementAndGet());
    }
}
