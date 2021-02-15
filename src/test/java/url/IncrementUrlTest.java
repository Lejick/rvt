package url;

import com.revolut.url.IncrementUrlGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncrementUrlTest {

    @Test
    public void increment_url_success_1() {
        String baseUrl="http://short.com/";
        IncrementUrlGenerator incrementUrlService = new IncrementUrlGenerator();
        assertEquals("http://short.com/1", baseUrl+incrementUrlService.generate());
        assertEquals("http://short.com/2", baseUrl+incrementUrlService.generate());
    }
}
