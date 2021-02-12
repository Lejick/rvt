import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadBalancer {
    private static final int MAXIMUM_PROVIDERS_COUNT_DEFAULT = 10;
    private static int maxSize = MAXIMUM_PROVIDERS_COUNT_DEFAULT;
    private List<Provider> providersList = new ArrayList<>();
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public void register(Provider provider) {
        checkMaximiumSize();
        providersList.add(provider);
    }

    private void checkMaximiumSize() {

        if (providersList.size() > maxSize) {
            throw new IllegalStateException();
        }
    }

    public Provider getProvider() {
        Random rand = new Random();
        return providersList.get(rand.nextInt(providersList.size()));
    }
}
