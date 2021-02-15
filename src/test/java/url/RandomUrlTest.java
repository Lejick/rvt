package url;

import com.revolut.url.RandomSequenceGenerator;
import com.revolut.url.ShortUrlService;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomUrlTest {

    // create random generator
    private static RandomSequenceGenerator randomSequenceGenerator = new RandomSequenceGenerator();

    @Test
    public void random_seq_generator_count() {
        assertEquals(4, randomSequenceGenerator.generate().length());
    }

    @Test
    public void random_seq_generator_alphabet() {
        String resultSeq = randomSequenceGenerator.generate();
        boolean isAlphanumeric = resultSeq.chars().allMatch(Character::isLetterOrDigit);
        assertEquals(true, isAlphanumeric);
    }

    @Test
    public void random_seq_generator_length() {
        int seqLength = 10;
        RandomSequenceGenerator generator = new RandomSequenceGenerator(seqLength);
        String resultSeq = generator.generate();
        assertEquals(seqLength, resultSeq.length());
    }

    @Test
    public void random_url_success() {
        String sourceUrl = "http://looooong.com/somepath";
        String baseUrl = "http://short.com/";
        int expectedLength = baseUrl.length() + 4;
        ShortUrlService shortUrlRandomService = new ShortUrlService(randomSequenceGenerator);

        String shortLink = shortUrlRandomService.generateShortLink(sourceUrl);

        assertEquals(expectedLength, shortLink.length());
    }

    @RepeatedTest(10)
    public void check_true_random_service() {
        String originalUrl = "http://looooong.com/somepath";
        ShortUrlService shortUrlRandomService = new ShortUrlService(randomSequenceGenerator);
        String randomShortUrl1 = shortUrlRandomService.generateShortLink(originalUrl);
        String randomShortUrl2 = shortUrlRandomService.generateShortLink(originalUrl);
        assertEquals(false, randomShortUrl1.equals(randomShortUrl2));
    }

    @Test
    public void random_url_success_retrieve() {
        String sourceUrl = "http://looooong.com/somepath";
        ShortUrlService shortUrlRandomService = new ShortUrlService(randomSequenceGenerator);
        String shortLink = shortUrlRandomService.generateShortLink(sourceUrl);
        String resultUrl = shortUrlRandomService.getSourceUrl(shortLink);
        assertEquals(sourceUrl, resultUrl);
    }
}
