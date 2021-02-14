package com.revolut.balancer;

import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinIndexGenerator implements IndexBalancerIF {
    private AtomicInteger currentIndex = new AtomicInteger(0);
    private AtomicInteger maxInt = new AtomicInteger(-1);

    public synchronized int nextIndex() {
        if (maxInt.get() < 0) {
            throw new IllegalStateException();
        }
        int result = currentIndex.get();
        if (currentIndex.get() == maxInt.get()) {
            currentIndex.set(0);
        } else {
            currentIndex.incrementAndGet();
        }
        return result;
    }

    public void incrementMax() {
        maxInt.incrementAndGet();
    }

    public void incrementMax(int count) {
        maxInt.addAndGet(count);
    }
}
