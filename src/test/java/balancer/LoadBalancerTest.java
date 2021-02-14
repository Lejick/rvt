package balancer;

import com.revolut.balancer.PureRandomIndexGenerator;
import com.revolut.balancer.RoundRobinIndexGenerator;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import com.revolut.balancer.LoadBalancer;
import com.revolut.balancer.Provider;

import java.util.ArrayList;
import java.util.List;

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

    @Test
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
        String name = "name1";
        loadBalancer.register(new Provider(name));
        loadBalancer.register(new Provider(name));
    }

    @RepeatedTest(100)
    public void generate_true_random() {
        PureRandomIndexGenerator generator = new PureRandomIndexGenerator();
        for (int i = 0; i < 100; i++) {
            generator.incrementMax();
        }
        List<Integer> randomList1 = new ArrayList<>();
        List<Integer> randomList2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomList1.add(generator.nextIndex());
            randomList2.add(generator.nextIndex());
        }
        boolean allSame = true;
        for (int i = 0; i < randomList1.size(); i++) {
            if (!randomList1.get(i).equals(randomList1.get(0))) {
                allSame = false;
            }
        }
        assertEquals(false, allSame);
    }


    @Test()
    public void round_robin_test_1() {
        RoundRobinIndexGenerator loadBalancer = new RoundRobinIndexGenerator();
        loadBalancer.incrementMax();
        loadBalancer.incrementMax();
        assertEquals(0, loadBalancer.nextIndex());
        assertEquals(1, loadBalancer.nextIndex());
        assertEquals(0, loadBalancer.nextIndex());
        assertEquals(1, loadBalancer.nextIndex());

    }

    @Test()
    public void round_robin_test_2() {
        RoundRobinIndexGenerator loadBalancer = new RoundRobinIndexGenerator();
        loadBalancer.incrementMax(5);
        for (int i = 0; i < 2; i++) {
            assertEquals(0, loadBalancer.nextIndex());
            assertEquals(1, loadBalancer.nextIndex());
            assertEquals(2, loadBalancer.nextIndex());
            assertEquals(3, loadBalancer.nextIndex());
            assertEquals(4, loadBalancer.nextIndex());
        }

    }


    @Test()
    public void round_robin_test_3() {
        LoadBalancer loadBalancer = new LoadBalancer(new RoundRobinIndexGenerator());
        String name1 = "name1";
        String name2 = "name2";
        loadBalancer.register(new Provider(name1));
        loadBalancer.register(new Provider(name2));

    }

}
