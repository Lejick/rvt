package com.revolut.url;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Generate increment sequence of integer
 * thread-safe
 */
public class IncrementUrlGenerator implements ShortUrlGenerator {
    private AtomicInteger index = new AtomicInteger(0);

    /**
     *
     * @return next integer
     */
    @Override
    public String generate() {
        return String.valueOf(index.incrementAndGet());
    }
}
