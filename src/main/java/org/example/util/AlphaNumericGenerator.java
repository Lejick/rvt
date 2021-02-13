package org.example.util;

import org.example.exception.StaticClassInstantiationException;

import java.util.Random;

/**
 * Generates a string with a sequence of random alphanumeric values
 */
public class AlphaNumericGenerator {

    private AlphaNumericGenerator() {
        throw new StaticClassInstantiationException();
    }

    private static final String ALPHA_NUMERIC_POOL = "QWERTYUIOPASDFGHJKLZXVBNMqwertyuiopasdfghjklzxcvbnm1234567890";

    public static String generateAlphaNumericSequenceWithLengthOf4() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char[] alphaNumericChars = ALPHA_NUMERIC_POOL.toCharArray();
            stringBuilder.append(alphaNumericChars[random.nextInt(ALPHA_NUMERIC_POOL.length())]);
        }
        return stringBuilder.toString();
    }
}
