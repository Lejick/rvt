package url;

import com.revolut.url.SeoWordChecker;
import com.revolut.url.SeoUrlService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SeoUrlTest {

    @ParameterizedTest
    @ValueSource(strings = {"POTATO", "MY-NEW-WS"})
    public void seo_url_success_1(final String seoWord) {
        String sourceUrl = "http://looooong.com/somepath";
        String expectedResult = "http://short.com/" + seoWord;
        SeoUrlService shortUrlService = new SeoUrlService();
        assertEquals(expectedResult, shortUrlService.createShortUrl(sourceUrl, seoWord));
    }

    @Test()
    public void seo_checkers_null() {
        assertThrows(IllegalArgumentException.class, () -> SeoWordChecker.check(null));

    }

    @Test
    public void seo_checkers_empty() {
        assertThrows(IllegalArgumentException.class, () -> SeoWordChecker.check(""));
    }

    @Test
    public void seo_checkers_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> SeoWordChecker.check("1234213412423421341234123421342134"));
    }

    @Test
    public void seo_url_longer_then_20() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = "POTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATOPOTATO";
        SeoUrlService shortUrlService = new SeoUrlService();
        assertThrows(IllegalArgumentException.class, () -> shortUrlService.createShortUrl(sourceUrl, seoWord));
    }

    @Test
    public void seo_url_null() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = null;

        SeoUrlService shortUrlService = new SeoUrlService();
        assertThrows(IllegalArgumentException.class, () -> shortUrlService.createShortUrl(sourceUrl, seoWord));
    }

    @Test
    public void seo_url_empty() {
        String sourceUrl = "http://looooong.com/somepath";
        String seoWord = "";

        SeoUrlService shortUrlService = new SeoUrlService();
        assertThrows(IllegalArgumentException.class, () -> shortUrlService.createShortUrl(sourceUrl, seoWord));
    }

    @Test
    public void short_url_no_such_element_2_retrieve() {
        SeoUrlService shortUrlService = new SeoUrlService();
        assertThrows(NoSuchElementException.class, () -> shortUrlService.getOriginalUrl("fake"));
    }


    @Test()
    public void short_url_element_retrieve() {
        String longPath = "http://looooong.com/somepath ";
        String seoWord = "POTATO";

        SeoUrlService shortUrlService = new SeoUrlService();
        shortUrlService.createShortUrl(longPath, seoWord);
        assertEquals(longPath, shortUrlService.getOriginalUrl(seoWord));
    }
}
