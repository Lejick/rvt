package test.revolut;

import java.util.Random;

public class RandomSequenceGenerator {
    private static final String NUMBERS = "0123456789";
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHABET_LOW = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
    private static final char[] charSeqArray = (NUMBERS + ALPHABET + ALPHABET_LOW).toCharArray();
    private Random random = new Random();


    public String generate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int randIndex = random.nextInt(charSeqArray.length);
            sb.append(charSeqArray[randIndex]);
        }
        return sb.toString();
    }
}
