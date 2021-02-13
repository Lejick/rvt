package url;

import com.revolut.url.SeoWordChecker;
import org.junit.Test;
import com.revolut.url.SeoUrlService;

import static org.junit.Assert.assertEquals;

public class SeoUrlTest {

    @Test
    public void seo_url_success_1() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = "MY-NEW-WS";
        String expectedResult = "http://short.com/MY-NEW-WS";

        SeoUrlService shortUrlService = new SeoUrlService();
        assertEquals(expectedResult, shortUrlService.createShortUrl(sourceUrl, seoWord));
    }


    @Test
    public void seo_url_success_2() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = "POTATO";
        String expectedResult = "http://short.com/POTATO";
        SeoUrlService shortUrlService = new SeoUrlService();
        assertEquals(expectedResult, shortUrlService.createShortUrl(sourceUrl, seoWord));
    }

    @Test(expected = IllegalArgumentException.class)
    public void seo_url_longer_then_20() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = "POTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATO";
        String expectedResult = "http://short.com/POTATO";
        SeoUrlService shortUrlService = new SeoUrlService();
        assertEquals(expectedResult, shortUrlService.createShortUrl(sourceUrl, seoWord));
    }

    @Test(expected = IllegalArgumentException.class)
    public void seo_url_null() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = null;
        String expectedResult = "http://short.com/POTATO";
        SeoUrlService shortUrlService = new SeoUrlService();
        assertEquals(expectedResult, shortUrlService.createShortUrl(sourceUrl, seoWord));
    }

    @Test(expected = IllegalArgumentException.class)
    public void seo_url_empty() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = "";
        String expectedResult = "http://short.com/";
        SeoUrlService shortUrlService = new SeoUrlService();
        assertEquals(expectedResult, shortUrlService.createShortUrl(sourceUrl, seoWord));
    }

    @Test
    public void get_original_url_success() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = "word1";
        SeoUrlService shortUrlService = new SeoUrlService();
        shortUrlService.createShortUrl(sourceUrl, seoWord);
        assertEquals(sourceUrl, shortUrlService.getOriginalUrl(seoWord));
    }

    @Test(expected = IllegalArgumentException.class)
    public void seo_checkers_null(){
        SeoWordChecker.check(null);

    }
    @Test(expected = IllegalArgumentException.class)
    public void seo_checkers_empty(){
        SeoWordChecker.check("");

    }
    @Test(expected = IllegalArgumentException.class)
    public void seo_checkers_tooLong(){
        SeoWordChecker.check("1234213412423421341234123421342134");

    }


}
