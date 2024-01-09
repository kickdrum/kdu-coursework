package org.backend1.QUE2;
import java.util.logging.Logger;
import java.util.Arrays;

public class SentimentAnalyzer {

    private static final Logger LOGGER = Logger.getLogger(SentimentAnalyzer.class.getName());


    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
                                          String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length]; // output

        review = review.toLowerCase(); // Convert review to lowercase

        outerLoop:
        for (int i = 0; i < featureSet.length; i++) {
            String[] synonyms = featureSet[i];

            for (int j = 0; j < synonyms.length; j++) {
                String feature = synonyms[j];

                int opinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);

                if (opinion != 0) {
                    featureOpinions[i] = opinion;
                    continue outerLoop;
                }
            }
        }

        return featureOpinions;
    }

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords,
                                           String[] negOpinionWords) {
        int opinion = 0;

        opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);

        if (opinion == 0) {
            opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }

        return opinion;
    }

    // Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
    // Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords,
                                                String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";

        // Look for positive opinion first
        for (String posWord : posOpinionWords) {
            if (review.contains(pattern + posWord)) {
                opinion = 1;
                break;
            }
        }

        // If positive opinion not found, look for negative opinion
        if (opinion == 0) {
            for (String negWord : negOpinionWords) {
                if (review.contains(pattern + negWord)) {
                    opinion = -1;
                    break;
                }
            }
        }

        return opinion;
    }

    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
                                                   String[] negOpinionWords) {
        // Extract sentences as the feature might appear multiple times.
        // split() takes a regular expression and "." is a special character
        // for a regular expression. So, escape it to make it work!!
        String[] sentences = review.split("\\.");
        int opinion = 0;

        // Process each sentence for the presence of opinions
        for (String sentence : sentences) {
            // Look for positive opinion first
            for (String posWord : posOpinionWords) {
                if (sentence.contains(posWord + " " + feature)) {
                    opinion = 1;
                    return opinion;
                }
            }

            // If positive opinion not found, look for negative opinion
            for (String negWord : negOpinionWords) {
                if (sentence.contains(negWord + " " + feature)) {
                    opinion = -1;
                    return opinion;
                }
            }
        }

        return opinion;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
        String[][] featureSet = { { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" }, { "food" }, { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };

        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
                "delicious" };

        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);

//        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
        LOGGER.info("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}
