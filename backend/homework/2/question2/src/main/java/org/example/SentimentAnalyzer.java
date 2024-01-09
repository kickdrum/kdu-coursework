package org.example;
import java.util.Arrays;

public class SentimentAnalyzer {
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];

        for (int i = 0; i < featureSet.length; i++) {
            for (String feature : featureSet[i]) {
                int opinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
                if (opinion != 0) {
                    featureOpinions[i] = opinion;
                    break; // It will Move to next feature if opinion found
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

        int startIndex = review.toLowerCase().indexOf(pattern.toLowerCase());
        if (startIndex != -1) {
            // getting substring after the pattern
            String opinionText = review.substring(startIndex + pattern.length());
            // Check for positive opinion
            for (String posWord : posOpinionWords) {
                if (opinionText.toLowerCase().startsWith(posWord.toLowerCase())) {
                    opinion = 1;
                    break;
                }
            }
            // check for negative opinion
            if (opinion == 0) {
                for (String negWord : negOpinionWords) {
                    if (opinionText.toLowerCase().startsWith(negWord.toLowerCase())) {
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
        String[] sentences = review.split("\\.");

        for (String sentence : sentences) {
            // Check for positive opinion
            for (String posWord : posOpinionWords) {
                if (sentence.toLowerCase().contains(posWord.toLowerCase() + " " + feature.toLowerCase())) {
                    opinion = 1;
                    break;
                }
            }
            //  check for negative opinion
            if (opinion == 0) {
                for (String negWord : negOpinionWords) {
                    if (sentence.toLowerCase().contains(negWord.toLowerCase() + " " + feature.toLowerCase())) {
                        opinion = -1;
                        break;
                    }
                }
            }
            // Break if an opinion is found in the sentence
            if (opinion != 0) {
                break;
            }
        }

        return opinion;
    }

}



