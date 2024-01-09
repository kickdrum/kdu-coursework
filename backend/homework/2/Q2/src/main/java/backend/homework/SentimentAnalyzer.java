package backend.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

/**
 * Analyzes text reviews to detect positive and negative sentiment about specific features.
 *
 * @author [Your Name]
 */
public class SentimentAnalyzer {

    /**
     * Logger for logging analysis events.
     */
    public static final Logger logger = LoggerFactory.getLogger(SentimentAnalyzer.class);
    /**
     * Analyzes a review and identifies positive or negative sentiment for each feature in the feature set.
     *
     * @param review the text of the review to analyze
     * @param featureSet a set of features to analyze sentiment for
     * @param posOpinionWords a list of words indicating positive sentiment
     * @param negOpinionWords a list of words indicating negative sentiment
     * @return an array of opinions, where each element represents the opinion (1 for positive, -1 for negative, 0 for neutral or no opinion found) for the corresponding feature in the feature set
     */
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];
        review = review.toLowerCase(); // Convert review to lowercase for case-insensitive matching


        for (int i = 0; i < featureSet.length; i++) {

            featureOpinions[i] = getOpinionOnFeature(review, featureSet[i], posOpinionWords, negOpinionWords);

        }
        return featureOpinions;
    }
    /**
     * Analyzes a review and extracts the opinion about a specific feature.
     *
     * @param review the text of the review to analyze
     * @param featureWords the words representing the feature to analyze
     * @param posOpinionWords a list of words indicating positive sentiment
     * @param negOpinionWords a list of words indicating negative sentiment
     * @return the opinion about the feature (1 for positive, -1 for negative, 0 for neutral or no opinion found)
     */
    private static int getOpinionOnFeature(String review, String[] featureWords, String[] posOpinionWords, String[] negOpinionWords) {
        for (String featureWord : featureWords) {

            int opinion = checkForWasPhrasePattern(review, featureWord, posOpinionWords, negOpinionWords);

            if (opinion != 0) {
                return opinion;
            }
            opinion = checkForOpinionFirstPattern(review, featureWord, posOpinionWords, negOpinionWords);

            if (opinion != 0) {
                return opinion;
            }
        }
        return 0; // No opinion found for any of the feature words
    }

    /**
     * Checks for a specific pattern where the feature is followed by "was" and an opinion word.
     *
     * @param review the text of the review to analyze
     * @param featureWord the word representing the feature
     * @param posOpinionWords a list of words indicating positive sentiment
     * @param negOpinionWords a list of words indicating negative sentiment
     * @return the opinion about the feature (1 for positive, -1 for negative, 0 for neutral or no opinion found)
     */
    private static int checkForWasPhrasePattern(String review, String featureWord, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = featureWord + " was ";
        int opinionIndex = review.indexOf(pattern);
        if (opinionIndex != -1) {
            String checkString = review.substring(opinionIndex+pattern.length()).trim();
            System.out.println(checkString);
            for (String posOpinion : posOpinionWords) {
                if (checkString.startsWith(posOpinion)) {
                    opinion = 1;
                    break;
                }
            }
            for (String negOpinion : negOpinionWords) {
                if (checkString.startsWith(negOpinion)) {
                    opinion = -1;
                    break;
                }
            }

        }
        return opinion;
    }

    /**
     * Checks for a pattern where an opinion word appears before the feature word.
     *
     * @param review the text of the review to analyze
     * @param featureWord the word representing the feature
     * @param posOpinionWords a list of words indicating positive sentiment
     * @param negOpinionWords a list of words indicating negative sentiment
     * @return the opinion about the feature (1 for positive, -1 for negative, 0 for neutral or no opinion found)
     */
    private static int checkForOpinionFirstPattern(String review, String featureWord, String[] posOpinionWords, String[] negOpinionWords) {
        int opinions = 0;
        String[] sentences = review.split("\\.");
        for (String sentence : sentences) {
            for (String posOpinionWord : posOpinionWords) {
                if (sentence.contains(posOpinionWord + " " + featureWord)) {
                    opinions = 1;
                    break;
                }
            }
            for (String negOpinionWord : negOpinionWords) {
                if (sentence.contains(negOpinionWord + " " + featureWord)) {
                    opinions = -1;
                    break;
                }
            }
        }
        return opinions;
    }

    /**
     * Demonstrates the usage of the SentimentAnalyzer class.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String review = "Haven't been here in years!Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
         // String review = "Sorry OG, but you just lost some loyal customers.Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress",
                        "bartender", "staff", "server" } };
        String[] posOpinionWords = { "good", "fantastic", "friendly",
                "great", "excellent", "amazing", "awesome",
                "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible",
                "awful", "unprofessional", "poor" };
        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        logger.info("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}

