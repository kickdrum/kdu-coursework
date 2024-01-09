package org.example;

import java.util.*;
public class SentimentAnalyzer {
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];

        for (int i = 0; i < featureSet.length; i++) {
            String[] featureSynonyms = featureSet[i];
            for (String feature : featureSynonyms) {
                int opinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
                if (opinion != 0) {
                    featureOpinions[i] = opinion;
                    break;
                }
            }
        }

        return featureOpinions;

    }

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);

        if (opinion == 0) {
            opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }

        return opinion;

    }

    private static int findOpinionInWords(String text, String[] posOpinionWords, String[] negOpinionWords) {
        for (String posWord : posOpinionWords) {
            if (text.toLowerCase().contains(posWord.toLowerCase())) {
                return 1;
            }
        }

        for (String negWord : negOpinionWords) {
            if (text.toLowerCase().contains(negWord.toLowerCase())) {
                return -1;
            }
        }

        return 0;
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";

        if (review.toLowerCase().contains(pattern.toLowerCase())) {
           opinion = findOpinionInWords(review, posOpinionWords, negOpinionWords);

        }

        return opinion;

    }
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String[] sentences = review.split("\\.");

        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(feature.toLowerCase())) {
                opinion = findOpinionInWords(sentence, posOpinionWords, negOpinionWords);
                if (opinion != 0) {
                    break;
                }
            }
        }

        return opinion;

    }
    public static void main(String[] args) {

        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
        //String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };

        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious" };

        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);

        LoggerClass.getLoggerOutput().info("Review: " + review);
        LoggerClass.getLoggerOutput().info("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}