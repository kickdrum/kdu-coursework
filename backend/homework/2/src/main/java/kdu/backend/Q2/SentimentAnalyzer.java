package kdu.backend.Q2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class SentimentAnalyzer {
    private static final Logger logger = LoggerFactory.getLogger(SentimentAnalyzer.class);

    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int size=featureSet.length;
        int[] featureOpinions = new int[size]; // output


        review = review.toLowerCase(); //for changing the review lowercase

        /*for iterating each feature and invoking getOpinionOnFeature*/
        Loop: // go to command so that we can continue the loop which we want as multiple loops are present.
        for (int i = 0; i < size; i++) {
            String[] feature = featureSet[i];
            for (String st : feature) {
                if (review.contains(st)) {
                    featureOpinions[i] = getOpinionOnFeature(review, st, posOpinionWords, negOpinionWords);
                    continue Loop;
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

        //positive opinion
        for (String posOpinionWord : posOpinionWords) {
            if (review.contains(pattern + posOpinionWord)) {
                opinion = 1;
                break;
            }
        }

        //negative opinion when positive was not found
        if (opinion == 0) {
            for (String negOpinionWord : negOpinionWords) {
                if (review.contains(pattern + negOpinionWord)) {
                    opinion = -1;
                    break;
                }
            }
        }

        logger.info("Opinion on {}: {}", feature, opinionToString(opinion));
        return opinion;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        /*Extract sentences as feature might appear multiple times.split() takes a regular expression and "." is a special for regular expression. So, escape it to make it work!!*/
        String[] sentences = review.split("\\.");


        for (String sentence : sentences) {
            // To check for positive opinion
            for (String posOpinionWord : posOpinionWords) {
                if (sentence.contains(posOpinionWord + " " + feature)) {
                    opinion = 1;
                    logger.info("Opinion on {}: {}", feature, opinionToString(opinion));
                    return opinion; //simply return the opinion here there is no need to process the next sentence
                }
            }
            // To check for negative opinion
            if (opinion == 0) {
                for (String negOpinionWord : negOpinionWords) {
                    if (sentence.contains(negOpinionWord + " " + feature)) {
                        opinion = -1;
                        logger.info("Opinion on {}: {}", feature, opinionToString(opinion));
                        return opinion; //simply return the opinion here there is no need to process the next sentence
                    }
                }
            }
        }

        return opinion;
    }

    private static String opinionToString(int opinion) {
        switch (opinion) {
            case 1:
                return "Positive";
            case -1:
                return "Negative";
            default:
                return "No Opinion";
        }
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definitely will be a frequent flyer! Francisco was very attentive";

        String[][] featureSet = {{"ambiance", "ambience", "atmosphere", "decor"}, {"dessert", "ice cream", "desert"}, {"food"}, {"soup"}, {"service", "management", "waiter", "waitress", "bartender", "staff", "server"}};

        String[] posOpinionWords = {"good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious"};
        String[] negOpinionWords = {"slow", "bad", "horrible", "awful", "unprofessional", "poor"};

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);

        logger.info("Opinions on Features: {}", Arrays.toString(featureOpinions));
    }
}
