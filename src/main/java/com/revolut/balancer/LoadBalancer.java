package com.revolut.balancer;

import java.util.*;

public class LoadBalancer {
    private static final int MAXIMUM_PROVIDERS_COUNT_DEFAULT = 10;
    private int maxSize;
    private ArrayList<Provider> providersList = new ArrayList<>();
    private IndexBalancerIF indexBalancerIF;


    public LoadBalancer() {
        maxSize = MAXIMUM_PROVIDERS_COUNT_DEFAULT;
        this.indexBalancerIF = new RandomExclusiveIndexGenerator();
    }


    public LoadBalancer(IndexBalancerIF indexBalancerIF) {
        maxSize = MAXIMUM_PROVIDERS_COUNT_DEFAULT;
        this.indexBalancerIF = indexBalancerIF;
    }

    public LoadBalancer(IndexBalancerIF indexBalancerIF, int maxSize) {
        this.maxSize = maxSize;
        this.indexBalancerIF = indexBalancerIF;
    }


    public void register(Provider provider) {
        checkMaximiumSize();
        checkAlreadyRegistered(provider);
        providersList.add(provider);
        indexBalancerIF.incrementMax();
    }

    private void checkAlreadyRegistered(Provider provider) {
        if (providersList.contains(provider)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMaximiumSize() {
        if (providersList.size() > maxSize) {
            throw new IllegalStateException();
        }
    }

    public synchronized Provider getProvider() {
        int nextIndex = indexBalancerIF.nextIndex();
        return providersList.get(nextIndex);
    }

}
