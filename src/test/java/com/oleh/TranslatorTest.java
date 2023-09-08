package com.oleh;


import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {

    @org.junit.jupiter.api.Test
    void translate() {
        String input = "This application will translate the English" +
                " text you enter into Pig Latin. It will retain CASE" +
                " and punctuation. It will also translate contractions," +
                " but it won't translate words that contain numbers or symbols," +
                " such as 86, bill@microsoft.com, or C#.";

        String expected = "Isthay applicationway illway anslatetray ethay Englishway" +
                " exttay ouyay enterway intoway Igpay Atinlay. Itway illway etainray" +
                " ASECAY andway unctuationpay. Itway illway alsoway anslatetray" +
                " ontractionscay, utbay itway on'tway anslatetray ordsway atthay " +
                "ontaincay umbersnay orway ymbolssay, uchsay asway 86, bill@microsoft.com, orway C#.";

        Translator translator = new Translator();

        String result = translator.translateToPigLatin(input);

        String[] previousWords = input.split("\\s");
        String[] resultWords = result.split("\\s");
        String[] expectedWords = expected.split("\\s");

        for (int i = 0; i < expectedWords.length; i++) {
            if (!resultWords[i].equals(expectedWords[i])) {
                System.out.println("It was: " + previousWords[i]);
                System.out.println("It is: " + resultWords[i]);
                System.out.println("Expected: " + expectedWords[i]);
                fail();
            }

        }

    }
}