package url;

import org.junit.Test;
import com.revolut.url.RandomSequenceGenerator;
import com.revolut.url.ShortUrlService;

import static org.junit.Assert.assertEquals;

public class RandomUrlTest {
    @Test
    public void random_url_success() {
        String sourceUrl = "http://looooong.com/somepath";
        String baseUrl = "http://short.com/";
        int expectedLength = baseUrl.length() + 4;
        ShortUrlService shortUrlRandomService = new ShortUrlService(new RandomSequenceGenerator());

        String shortLink = shortUrlRandomService.generateShortLink(sourceUrl);

        assertEquals(expectedLength, shortLink.length());
    }

    @Test
    public void random_url_success_retrieve() {
        String sourceUrl = "http://looooong.com/somepath";
        ShortUrlService shortUrlRandomService = new ShortUrlService(new RandomSequenceGenerator());
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
