import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.Assert.assertEquals;

public class LoadBalancerTest {

    @Test(expected = IllegalStateException.class)
    public void register_balancer_exceed_limit() {
        LoadBalancer loadBalancer = new LoadBalancer();
        for (int i = 0; i < 15; i++) {
            String name = "Provider " + i;
            loadBalancer.register(new Provider(name));
        }
    }

    @Test
    public void register_balancer_success() {
        LoadBalancer loadBalancer = new LoadBalancer();
        for (int i = 0; i < 10; i++) {
            String name = "Provider " + i;
            loadBalancer.register(new Provider(name));
        }
    }

    @RepeatedTest(10)
    public void get_one_provider() {
        LoadBalancer loadBalancer = new LoadBalancer();
        Provider provider = new Provider("name1");
        loadBalancer.register(provider);
        Provider registeredProvider = loadBalancer.getProvider();
        assertEquals(provider, registeredProvider);
    }
}
