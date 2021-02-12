import org.junit.Test;
import test.revolut.url.IncrementUrlGenerator;
import static org.junit.Assert.assertEquals;

public class IncrementUrlTest {

    @Test
    public void seo_url_success_1() {
        String baseUrl="http://short.com/";
        IncrementUrlGenerator incrementUrlService = new IncrementUrlGenerator();
        assertEquals("http://short.com/1", baseUrl+incrementUrlService.generate());
        assertEquals("http://short.com/2", baseUrl+incrementUrlService.generate());
    }
}
