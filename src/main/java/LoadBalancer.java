import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {
    private static final int MAXIMUM_PROVIDERS_COUNT_DEFAULT = 10;
    private static int maxSize = MAXIMUM_PROVIDERS_COUNT_DEFAULT;
    private List<Provider> providersList = new ArrayList<Provider>();

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
        return providersList.get(0);
    }
}
