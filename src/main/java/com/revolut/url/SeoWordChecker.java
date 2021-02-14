package com.revolut.url;

/**
 * Util class for checking word correctly
 */
public class SeoWordChecker {
    public static final int MAX_SEO_WORD_LENGTH = 20;
    public static final String ERROR_MESSAGE_MAX_LENGTH = "Seo word max length is " + MAX_SEO_WORD_LENGTH;
    public static final String ERROR_MESSAGE_EMPTY = "Seo word can't be empty";
    public static final String ERROR_MESSAGE_NULL = "Seo word can't be null";

    public static void check(String seoWord) {
        if (seoWord == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NULL);
        }
        if (seoWord.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY);
        }
        if (seoWord.length() > MAX_SEO_WORD_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MAX_LENGTH);
        }
    }
}
