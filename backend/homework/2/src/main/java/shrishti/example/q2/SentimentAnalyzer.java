package shrishti.example.q2;
import java.util.Arrays;


public class SentimentAnalyzer {

    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];

        for (int i = 0; i < featureSet.length; i++) {
            for (int j = 0; j < featureSet[i].length; j++) {

                int opinion = getOpinionOnFeature(review, featureSet[i][j], posOpinionWords, negOpinionWords);
                if(opinion!=0){
                    featureOpinions[i] = opinion;
                    break;
                }
            }
        }
        return featureOpinions;
    }


    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        int wasOutput = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (wasOutput != 0) {
            return wasOutput;
        } else {
            wasOutput = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
            return wasOutput;
        }
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        String pattern = feature + " was ";
        if (review.contains(pattern)) {
            for (String word : posOpinionWords) {
                if (review.contains(pattern + word)) {
                    return 1;
                }
            }
            for (String word : negOpinionWords) {
                if (review.contains(pattern + word)) {
                    return -1;
                }
            }
        }
        return 0;
    }


    private static int checkForOpinionFirstPattern(String review, String feature, String[]
            posOpinionWords, String[] negOpinionWords) {

        for (String word : posOpinionWords) {
            if (review.contains(word + " " +feature))
                return 1;
        }

        for(String word :  negOpinionWords){
            if(review.contains(word+ " " +feature))
                return -1;
        }
        return 0;
    }



    public static void main(String[] args){
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
        review=review.toLowerCase();
        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing",
                "awesome", "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] Userreview  = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);


        System.out.println("Opinions on Features: " + Arrays.toString(Userreview));

    }


}


//  reviews of entities, titles, reviews
//restraunts, hotels, books
// restraunts : service, ambiance, individual, food, car parking,
// review - +ve or -ve or no
// feature : pro or con
// feature ->opinion
// SentimentAnalyzer :
// public static int[] detectProsAndCons(String review, String[][] featureSet, String[]
//posOpinionWords, String[] negOpinionWords): MAINNN
// private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords,
//String[] negOpinionWords): Invoked from detectProsAndCons
//private static int checkForWasPhrasePattern(String review, String feature, String[]
//posOpinionWords, String[] negOpinionWords):
// private static int checkForOpinionFirstPattern(String review, String feature, String[]
//posOpinionWords, String[] negOpinionWords): In this method, you will look for the second
//pattern {opinion} {feature}