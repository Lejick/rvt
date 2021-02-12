import org.junit.Test;
import test.revolut.url.IncrementUrlGenerator;
import test.revolut.url.RandomSequenceGenerator;
import test.revolut.url.ShortUrlService;

import static org.junit.Assert.assertNotEquals;

public class FactoryUrlServiceTest {


    @Test
    public void get_different_type_link() {
        ShortUrlService incrementUrlService = new ShortUrlService(new IncrementUrlGenerator());
        ShortUrlService randomUrlService = new ShortUrlService(new RandomSequenceGenerator());
        String originUrl = "http://looooong.com/somepath";
        String short1 = incrementUrlService.generateShortLink(originUrl);
        String short2 = randomUrlService.generateShortLink(originUrl);
        assertNotEquals(short1, short2);
    }
}
