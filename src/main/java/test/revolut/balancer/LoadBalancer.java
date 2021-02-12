package test.revolut.balancer;

import java.util.*;

public class LoadBalancer {
    private static final int MAXIMUM_PROVIDERS_COUNT_DEFAULT = 10;
    private static int maxSize = MAXIMUM_PROVIDERS_COUNT_DEFAULT;
    private Set<Provider> providersSet = new HashSet<>();
    private ArrayList<Provider> remaining = new ArrayList<>();

    public void register(Provider provider) {
        checkMaximiumSize();
        checkAlreadyRegistered(provider);
        providersSet.add(provider);
    }

    private void checkAlreadyRegistered(Provider provider) {
        if (providersSet.contains(provider)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMaximiumSize() {
        if (providersSet.size() > maxSize) {
            throw new IllegalStateException();
        }
    }

    public synchronized Provider getProvider() {
        checkRemains();
        Random rand = new Random();
        Provider provider = remaining.get(rand.nextInt(remaining.size()));
        remaining.remove(provider);
        return provider;
    }

    private void checkRemains() {
        if (remaining.size() == 0) {
            remaining = new ArrayList<>(providersSet);
        }
    }
}
