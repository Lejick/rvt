package url;

import com.revolut.url.UrlServiceFactory;
import org.junit.Test;
import com.revolut.url.IncrementUrlGenerator;
import com.revolut.url.RandomSequenceGenerator;
import com.revolut.url.ShortUrlService;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void get_different_type_link_factory() {
        String originUrl = "http://looooong.com/somepath";

        ShortUrlService incrementUrlService = UrlServiceFactory.getIncrementUrlService();
        ShortUrlService randomUrlService = UrlServiceFactory.getRandomUrlService();

        String short1 = incrementUrlService.generateShortLink(originUrl);
        String short2 = randomUrlService.generateShortLink(originUrl);

        assertNotEquals(short1, short2);
    }

    @Test
    public void get_2_url_link() {
        String originUrl = "http://looooong.com/somepath";

        ShortUrlService incrementUrlService = UrlServiceFactory.getIncrementUrlService();

        String short1 = incrementUrlService.generateShortLink(originUrl);
        String short2 = incrementUrlService.generateShortLink(originUrl);

        assertEquals("http://short.com/1", short1);
        assertEquals("http://short.com/2", short2);
    }

    @Test
    public void get_2_url_link_same() {
        String originUrl = "http://looooong.com/somepath";

        ShortUrlService incrementUrlService1 = UrlServiceFactory.getIncrementUrlService();
        ShortUrlService incrementUrlService2 = UrlServiceFactory.getIncrementUrlService();
        String short1 = incrementUrlService1.generateShortLink(originUrl);
        String short2 = incrementUrlService2.generateShortLink(originUrl);

        assertEquals("http://short.com/1", short1);
        assertEquals("http://short.com/1", short2);
    }
}
