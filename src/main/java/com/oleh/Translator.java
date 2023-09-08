package com.oleh;


public class Translator {

    private enum Case {
        CAPS, TITLE_CASE, LOWERCASE
    }

    private final char[] uniqueSymbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '@', '#', '$', '%', '^', '&', '+', '-', '*', '/'};
    private final char[] punctuation = {',', '.', '!', '?', ';', ':'};
    private final char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'};

    public Translator() {
    }

    public String translateToPigLatin(String textToTranslate) {
        String[] words = textToTranslate.split("\\s");

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            word = translateWord(word);
            result.append(word).append(' ');
        }

        return result.toString();
    }

    private String translateWord(String word) {
        String punctuationSymbol = "";
        if (wordEndsWithPunctuation(word)) {
            punctuationSymbol += word.charAt(word.length() - 1);
            word = word.substring(0, word.length() - 1);
        }

        if (wordContainUniqueSymbol(word)) {
            return word + punctuationSymbol;
        } else if (wordStartsWithVowel(word)) {
            return addWayTo(word) + punctuationSymbol;
        } else {
            return consonantTranslation(word) + punctuationSymbol;
        }

    }

    private boolean wordEndsWithPunctuation(String word) {
        for (char symbol : punctuation) {
            if (symbol == word.charAt(word.length() - 1)) {
                return true;
            }
        }

        return false;
    }

    private boolean wordContainUniqueSymbol(String word) {

        for (char letter : word.toCharArray()) {
            for (char symbol : uniqueSymbols) {
                if (letter == symbol) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean wordStartsWithVowel(String word) {

        for (char vowel : vowels) {
            if (word.charAt(0) == vowel && word.charAt(0) != 'y' && word.charAt(0) != 'Y') {
                return true;
            }
        }
        return false;
    }

    private String addWayTo(String word) {
        Case wordCase = checkCaseOf(word);

        if (wordCase == Case.CAPS) {
            return word + "WAY";
        }

        return word + "way";

    }

    private String consonantTranslation(String word) {

        boolean breaker = true;
        int vowelsIndex = 1;
        for (int i = 1; i < word.length() && breaker; i++) {
            for (char vowel : vowels) {
                if (vowel == word.charAt(i)) {
                    vowelsIndex = i;
                    breaker = false;
                    break;
                }
            }
        }

        Case wordCase = checkCaseOf(word);

        if (wordCase == Case.LOWERCASE) {
            return word.substring(vowelsIndex) + word.substring(0, vowelsIndex) + "ay";
        }

        if (wordCase == Case.CAPS) {
            return word.substring(vowelsIndex) + word.substring(0, vowelsIndex) + "AY";
        }

        return Character.toUpperCase(word.charAt(vowelsIndex))
                + word.substring(vowelsIndex + 1)
                + Character.toLowerCase(word.charAt(0))
                + word.substring(1, vowelsIndex)
                + "ay";

    }

    Case checkCaseOf(String word) {

        if ((int) (word.charAt(0)) < 96) {

            if (word.length() > 1) {
                if (word.charAt(1) < 96) {
                    return Case.CAPS;
                } else return Case.TITLE_CASE;
            } else return Case.CAPS;
        }

        return Case.LOWERCASE;
    }

}