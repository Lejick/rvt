package com.revolut.url;

/**
 * Util class for checking word correctly
 */
public class SeoWordChecker {

    public static void check(String seoWord) {
        if (seoWord == null) {
            throw new IllegalArgumentException(ShortUrlConst.ERROR_MESSAGE_NULL);
        }
        if (seoWord.isEmpty()) {
            throw new IllegalArgumentException(ShortUrlConst.ERROR_MESSAGE_EMPTY);
        }
        if (seoWord.length() > ShortUrlConst.MAX_SEO_WORD_LENGTH) {
            throw new IllegalArgumentException(ShortUrlConst.ERROR_MESSAGE_MAX_LENGTH);
        }
    }
}
