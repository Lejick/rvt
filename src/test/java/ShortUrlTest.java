import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortUrlTest {

    @Test
    public void seo_url_success_1() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = "MY-NEW-WS";
        String expectedResult = "http://short.com/MY-NEW-WS";

        ShortUrlService shortUrlService = new ShortUrlService();
        assertEquals(expectedResult, shortUrlService.createShortUrl(sourceUrl, seoWord));
    }


    @Test
    public void seo_url_success_2() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = "POTATO";
        String expectedResult = "http://short.com/POTATO";
        ShortUrlService shortUrlService = new ShortUrlService();
        assertEquals(expectedResult, shortUrlService.createShortUrl(sourceUrl, seoWord));
    }

    @Test(expected = IllegalArgumentException.class)
    public void seo_url_longer_then_20() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = "POTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATO";
        String expectedResult = "http://short.com/POTATO";
        ShortUrlService shortUrlService = new ShortUrlService();
        assertEquals(expectedResult, shortUrlService.createShortUrl(sourceUrl, seoWord));
    }

    @Test(expected = IllegalArgumentException.class)
    public void seo_url_null() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = null;
        String expectedResult = "http://short.com/POTATO";
        ShortUrlService shortUrlService = new ShortUrlService();
        assertEquals(expectedResult, shortUrlService.createShortUrl(sourceUrl, seoWord));
    }

    @Test(expected = IllegalArgumentException.class)
    public void seo_url_empty() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = "";
        String expectedResult = "http://short.com/";
        ShortUrlService shortUrlService = new ShortUrlService();
        assertEquals(expectedResult, shortUrlService.createShortUrl(sourceUrl, seoWord));
    }
}
