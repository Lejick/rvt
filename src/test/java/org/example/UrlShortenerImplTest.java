package org.example;

import org.example.exception.SeoKeywordContainsSlash;
import org.example.exception.SeoKeywordIsEmpty;
import org.example.exception.SeoKeywordIsNull;
import org.example.exception.SeoKeywordIsTooLong;
import org.example.service.UrlShortener;
import org.example.service.UrlShortenerImpl;
import org.example.util.ApplicationEnvironment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test cases for url shortener
 */

class UrlShortenerImplTest {

    private final UrlShortener urlShortenerImpl = new UrlShortenerImpl();

    @Test
    void getShortenedUrl_Positive_EqualsPreconditionedUri() {
        String incomingUrl = "https://someurl/";
        String seoKeyword = "positivecase";
        String expectedUri = ApplicationEnvironment.applicationUrl + seoKeyword;
        String actualUri = urlShortenerImpl.getShortenedUrl(incomingUrl, seoKeyword);
        Assertions.assertEquals(expectedUri, actualUri);
    }

    @Test
    void getShortenedUrl_SeoKeywordContainsSlash_ThrowsSeoKeywordContainsSlashException() {
        String seoKeyword = "te/stst";
        Assertions.assertThrows(SeoKeywordContainsSlash.class,
                () -> urlShortenerImpl.getShortenedUrl(ApplicationEnvironment.applicationUrl, seoKeyword));
    }

    @Test
    void getShortenedUrl_SeoKeywordLongerThan20Symbols_ThrowsSeoKeywordIsTooLong() {
        String seoKeyword = "qwertyuiopasdfghjklxcvbnm";
        Assertions.assertThrows(SeoKeywordIsTooLong.class,
                () -> urlShortenerImpl.getShortenedUrl(ApplicationEnvironment.applicationUrl, seoKeyword));
    }

    @Test
    void getShortenedUrl_SeoKeywordIsNull_ThrowsSeoKeywordIsNull() {
        String seoKeyword = null;
        Assertions.assertThrows(SeoKeywordIsNull.class, () -> urlShortenerImpl
                .getShortenedUrl(ApplicationEnvironment.applicationUrl, seoKeyword));
    }


    @Test
    void getShortenedUrl_SeoKeywordIsEmpty_ThrowsSeoKeywordIsEmpty() {
        String seoKeyword = "";
        Assertions.assertThrows(SeoKeywordIsEmpty.class,
                () -> urlShortenerImpl.getShortenedUrl(ApplicationEnvironment.applicationUrl, seoKeyword));
    }
}
