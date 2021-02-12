import org.junit.Test;
import test.revolut.RandomSequenceGenerator;
import test.revolut.ShortUrlRandomService;
import test.revolut.ShortUrlService;

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

    @Test
    public void random_url_success() {
        String sourceUrl = "http://looooong.com/somepath";
        String baseUrl = "http://short.com/";
        int expectedLength = baseUrl.length() + 4;
        ShortUrlRandomService shortUrlRandomService = new ShortUrlRandomService();

        String shortLink = shortUrlRandomService.generateShortLink(sourceUrl);

        assertEquals(expectedLength, shortLink.length());
    }

    @Test
    public void random_url_success_retrieve() {
        String sourceUrl = "http://looooong.com/somepath";
        ShortUrlRandomService shortUrlRandomService = new ShortUrlRandomService();
        String shortLink = shortUrlRandomService.generateShortLink(sourceUrl);
        String resultUrl = shortUrlRandomService.getSourceUrl(shortLink);
        assertEquals(sourceUrl, resultUrl);
    }

    @Test
    public void random_seq_generator_count() {
        RandomSequenceGenerator generator = new RandomSequenceGenerator();

        assertEquals(4, generator.generate().length());
    }

    @Test
    public void random_seq_generator_alphabet() {
        RandomSequenceGenerator generator = new RandomSequenceGenerator();
        String resultSeq = generator.generate();
        boolean isAlphanumeric = resultSeq.chars().allMatch(Character::isLetterOrDigit);
        assertEquals(true, isAlphanumeric);
    }
}
