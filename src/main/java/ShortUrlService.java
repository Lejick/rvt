public class ShortUrlService {

    public String createShortUrl(String sourceUrl, String seoWord) {
        checkSeoWord(seoWord);
        return ShortUrlConst.BASE_URL + seoWord;
    }

    private void checkSeoWord(String seoWord) {
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
