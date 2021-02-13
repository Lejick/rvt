package com.revolut.url;

import java.util.Random;

public class RandomSequenceGenerator implements ShortUrlGenerator{
    private static final String NUMBERS = "0123456789";
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHABET_LOW = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
    private static final char[] charSeqArray = (NUMBERS + ALPHABET + ALPHABET_LOW).toCharArray();



    @Override
    public String generate() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int randIndex = random.nextInt(charSeqArray.length);
            sb.append(charSeqArray[randIndex]);
        }
        return sb.toString();
    }
}