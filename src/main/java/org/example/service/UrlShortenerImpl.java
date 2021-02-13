package org.example.service;

import org.example.util.AlphaNumericGenerator;
import org.example.util.ApplicationEnvironment;
import org.example.util.SeoKeywordValidator;

public class UrlShortenerImpl implements UrlShortener {

    public String getShortenedUrl(String uri, String seoKeyword) {
        validateSeoKeyword(seoKeyword);
        return ApplicationEnvironment.applicationUrl + seoKeyword;
    }

    public String getUrlWithRandomPath(String uri) {
        return ApplicationEnvironment.applicationUrl +
                AlphaNumericGenerator.generateAlphaNumericSequenceWithLengthOf4();
    }

    /**
     * method for seo keyword aggregated validation.
     *
     * @param seoKeyword input by the user
     */
    private void validateSeoKeyword(String seoKeyword) {
        SeoKeywordValidator.validateIfSeoKeywordIsNull(seoKeyword);
        SeoKeywordValidator.validateIfSeoKeywordIsTooLong(seoKeyword);
        SeoKeywordValidator.validateIfSeoKeywordContainsSlash(seoKeyword);
        SeoKeywordValidator.validateIfSeoKeywordIsEmpty(seoKeyword);
    }
}
