package org.example.util;

import org.example.exception.*;

public class SeoKeywordValidator {

    private SeoKeywordValidator() {
        throw new StaticClassInstantiationException();
    }

    public static void validateIfSeoKeywordIsNull(final String seoKeyword) {
        if (seoKeyword == null) {
            throw new SeoKeywordIsNull();
        }
    }

    public static void validateIfSeoKeywordIsEmpty(final String seoKeyword) {
        if (seoKeyword.isEmpty()) {
            throw new SeoKeywordIsEmpty();
        }
    }

    public static void validateIfSeoKeywordIsTooLong(final String seoKeyword) {
        if (seoKeyword.length() > 20) {
            throw new SeoKeywordIsTooLong();
        }
    }

    public static void validateIfSeoKeywordContainsSlash(final String seoKeyword) {
        if (seoKeyword.contains("/")) {
            throw new SeoKeywordContainsSlash();
        }
    }
}
