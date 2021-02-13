package com.revolut.balancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomIndexGenerator implements IndexBalancerIF {
    private List<Integer> used = new ArrayList<>();
    private AtomicInteger maxInt = new AtomicInteger(0);

    public synchronized int nextIndex() {
        Random rand = new Random();
        Integer index = rand.nextInt(maxInt.get());
        while (used.contains(index)) {
            index = rand.nextInt(maxInt.get());
        }
        used.add(index);
        return index;
    }

    public void incrementMax() {
        maxInt.incrementAndGet();
    }
}
