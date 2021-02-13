package balancer;

import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import com.revolut.balancer.LoadBalancer;
import com.revolut.balancer.Provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

    @RepeatedTest(10)
    public void get_two_providers() {
        LoadBalancer loadBalancer = new LoadBalancer();
        for (int i = 0; i < 10; i++) {
            String name = "Provider " + i;
            loadBalancer.register(new Provider(name));
        }
        Provider registeredProvider1 = loadBalancer.getProvider();
        Provider registeredProvider2 = loadBalancer.getProvider();
        assertNotEquals(registeredProvider1, registeredProvider2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void register_twice() {
        LoadBalancer loadBalancer = new LoadBalancer();
        String name="name1";
        loadBalancer.register(new Provider(name));
        loadBalancer.register(new Provider(name));
    }
}
