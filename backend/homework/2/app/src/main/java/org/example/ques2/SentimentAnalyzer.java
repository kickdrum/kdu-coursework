package org.example.ques2;

import org.example.Log;

import java.util.Arrays;

public class SentimentAnalyzer {
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        review = review.toLowerCase();
        int[] featureOpinions = new int[featureSet.length];

        nextFeature:for (int featureNumber = 0; featureNumber < featureSet.length; featureNumber++) {
            String[] featureSetForFeature = featureSet[featureNumber];

            for (String feature : featureSetForFeature) {
                feature = feature.toLowerCase();
                if (review.contains(feature)) {
                    int opinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
                    featureOpinions[featureNumber] = opinion;
                    continue nextFeature;
                } else {
                    featureOpinions[featureNumber] = 0;
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

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";
        int patternIndex = review.indexOf(pattern);
        if (patternIndex >= 0) {
            String subSentence = review.substring(patternIndex + pattern.length());
            int idx = 0;
            while (subSentence.charAt(idx) >= 'a' && subSentence.charAt(idx) <= 'z') {
                idx++;
            }
            String opinionWord = subSentence.substring(0, idx);
            for (String posWord : posOpinionWords) {
                if (posWord.equals(opinionWord)) {
                    opinion = 1;
                    break;
                }
            }
            if (opinion == 0) {
                for (String negWord : negOpinionWords) {
                    if (negWord.equals(opinionWord)) {
                        opinion = -1;
                        break;
                    }
                }
            }
        }
        return opinion;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        int featureIndex = review.indexOf(feature);
        String subSentence = review.substring(0, featureIndex);
        if (subSentence.isEmpty()) {
            return opinion;
        }
        String[] words = subSentence.split(" ");
        int n = words.length;
        String opinionWord = words[n - 1];
        for (String posWord : posOpinionWords) {
            if (posWord.equals(opinionWord)) {
                opinion = 1;
                break;
            }
        }
        if (opinion==0) {
            for (String negWord : negOpinionWords) {
                if (negWord.equals(opinionWord)) {
                    opinion = -1;
                    break;
                }
            }
        }

        return opinion;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";

        String[][] featureSet = {
                {"ambiance", "ambience", "atmosphere", "decor"},
                {"dessert", "ice cream", "desert"},
                {"food"},
                {"soup"},
                {"service", "management", "waiter", "waitress", "bartender", "staff", "server"}
        };
        String[] posOpinionWords = {"good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious"};
        String[] negOpinionWords = {"slow", "bad", "horrible", "awful", "unprofessional", "poor"};

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);

        Log.logger.info("Opinions on Features: " + Arrays.toString(featureOpinions));


    }
}
