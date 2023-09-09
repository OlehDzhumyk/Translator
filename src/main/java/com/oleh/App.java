package com.oleh;

public class App {

    public static void main(String[] args) {
        Translator pigLatinTranslator = new Translator();

        String input = "This application will the English"
                + " text you enter into Pig Latin. It will retain CASE"
                + " and punctuation. It will also translateToPigLatin contractions,"
                + " but it won't translateToPigLatin words that contain numbers or symbols,"
                + " such as 86, bill@microsoft.com, or C#.";

        System.out.println(pigLatinTranslator.translateToPigLatin(input));

        System.out.println("This application will the English"
                + " text you enter into Pig Latin. It will retain CASE"
                + " and punctuation. It will also translateToPigLatin contractions,"
                + " but it won't translateToPigLatin words that contain numbers or symbols,"
                + " such as 86, bill@microsoft.com, or C#.");
    }
}
