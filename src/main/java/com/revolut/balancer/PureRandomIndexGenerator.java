package com.revolut.balancer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class PureRandomIndexGenerator implements IndexBalancerIF {
    private AtomicInteger maxInt = new AtomicInteger(0);

    public synchronized int nextIndex() {
        Random rand = new Random();
        Integer index = rand.nextInt(maxInt.get());
        return index;
    }

    public void incrementMax() {
        maxInt.incrementAndGet();
    }
}
