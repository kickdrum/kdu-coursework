package org.example;
import java.util.Arrays;
public class SentimentAnalyzer {
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];
        review = review.toLowerCase();

        for (int i = 0; i < featureSet.length; i++) {
            boolean findFlag = false;

            for (int j = 0; j < featureSet[i].length; j++) {
                if (review.contains(featureSet[i][j])) {
                    findFlag = true;
                    int opinion = getOpinionOnFeature(review, featureSet[i][j], posOpinionWords, negOpinionWords);
                    featureOpinions[i] = opinion;
                    break;
                }
            }

            if (!findFlag) {
                featureOpinions[i] = 0;
            }
        }

        return featureOpinions;
    }

    public static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
            int opinion = 0;

            int wasOpinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
            if (wasOpinion != 0) {
                opinion = wasOpinion;
            }

            int opinionFirst = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
            if (opinionFirst != 0) {
                opinion = opinionFirst;
            }


        return opinion;
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";
        int startIndex = review.indexOf(pattern);

        if (startIndex != -1) {
            int endIndex = review.indexOf(" ", startIndex + pattern.length());
            if (endIndex == -1) {
                endIndex = review.length();
            }

            String opinionWord = review.substring(startIndex + pattern.length(), endIndex).toLowerCase();
            if (Arrays.asList(posOpinionWords).contains(opinionWord)) {
                opinion = 1;
            } else if (Arrays.asList(negOpinionWords).contains(opinionWord)) {
                opinion = -1;
            }
        }
        return opinion;
    }
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;

        int startIndex = review.indexOf(feature);
        startIndex-=2;
        String word="";
        while(startIndex+1>=0 && review.charAt(startIndex)!=' '){
            word+=review.charAt(startIndex);
            startIndex--;
        }
        String rev = "";
        for(int i = word.length() - 1; i >= 0; i--)
        {
            rev = rev + word.charAt(i);
        }
        word=rev;
        if (Arrays.asList(posOpinionWords).contains(word)) {
            opinion = 1;
        } else if (Arrays.asList(negOpinionWords).contains(word)) {
            opinion = -1;
        }
        return opinion;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious ! Definitely will be a frequent flyer! Francisco was very attentive";
        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };
        review=review.toLowerCase();
        System.out.println(review);

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}
