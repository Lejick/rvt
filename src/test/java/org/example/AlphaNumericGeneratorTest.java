package org.example;


import org.example.util.AlphaNumericGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlphaNumericGeneratorTest {

    @Test
    void generateAlphaNumericSequence_Positive_LengthEquals4() {
        int expectedLength = 4;
        int actualLength = AlphaNumericGenerator.generateAlphaNumericSequenceWithLengthOf4().length();
        Assertions.assertEquals(expectedLength, actualLength);
    }

    @Test
    void generateAlphaNumericSequence_Positive_ResultContainsUniqueCharacters() {
        String resultingSequence = AlphaNumericGenerator.generateAlphaNumericSequenceWithLengthOf4();
        int allSymbolsNumber = resultingSequence.length();
        long uniqueSymbolsNumber = resultingSequence.chars().distinct().count();
        Assertions.assertEquals(allSymbolsNumber, uniqueSymbolsNumber);
    }

}
