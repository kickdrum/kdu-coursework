package org.example;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definitely will be a frequent flyer! Francisco was very attentive";

        String[][] featureSet = {
                {"ambiance", "ambience", "atmosphere", "decor"},
                {"dessert", "ice cream", "desert"},
                {"food"},
                {"soup"},
                {"service", "management", "waiter", "waitress", "bartender", "staff", "server"}
        };

        String[] posOpinionWords = {"good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious"};
        String[] negOpinionWords = {"slow", "bad", "horrible", "awful", "unprofessional", "poor"};


        SentimentAnalyzer Sa = new SentimentAnalyzer();
        int[] featureOpinions = Sa.detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
        //s return 1 for positive opinion, -1 for negative opinion, and 0 when no
        //opinion could be found
    }
}