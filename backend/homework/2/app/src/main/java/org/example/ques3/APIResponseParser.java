package org.example.ques3;

import org.example.Log;

public class APIResponseParser {
    private static String extractString(int startRuleIndex, String response, String[] startRule, String endRule){
        String resultStr = response.substring(response.indexOf(startRule[startRuleIndex]) + startRule[startRuleIndex].length());
        resultStr = resultStr.substring(0, resultStr.indexOf(endRule));
        return resultStr;
    }
    private static Book parse(String response, String[] startRule, String endRule){
        Book book = new Book();
        String resultStr = extractString(0, response, startRule, endRule);
        book.setTitle(resultStr);

        resultStr = extractString(1, response, startRule, endRule);
        book.setAuthor(resultStr);

        resultStr = extractString(2, response, startRule, endRule);
        book.setPublicationYear(Integer.parseInt(resultStr));

        resultStr = extractString(3, response, startRule, endRule);
        book.setAverageRating(Double.parseDouble(resultStr));

        resultStr = extractString(4, response, startRule, endRule);
        resultStr = resultStr.replaceAll(",", "");
        book.setRatingsCount(Integer.parseInt(resultStr));

        resultStr = extractString(5, response, startRule, endRule);
        book.setImageUrl(resultStr);

        return book;
    }
    private static String parse(String response, String startRule, String endRule) {
        String resultStr = response.substring(response.indexOf(startRule) + startRule.length());

        resultStr = resultStr.substring(0, resultStr.indexOf(endRule));

        return resultStr;
    }

    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);

        startRule = "<name>";
        String author = parse(response, startRule, endRule);

        startRule = "<original_publication_year type=\"integer\">";
        String publicationYear = parse(response, startRule, endRule);

        startRule = "<average_rating>";
        String avgRating = parse(response, startRule, endRule);

        startRule = "<ratings_count type=\"integer\">";
        String ratingsCount = parse(response, startRule, endRule);
        ratingsCount = ratingsCount.replaceAll(",", "");

        startRule = "<image_url>";
        String imageUrl = parse(response, startRule, endRule);


        book.setTitle(title);
        book.setAuthor(author);
        book.setPublicationYear(Integer.parseInt(publicationYear));
        book.setAverageRating(Double.parseDouble(avgRating));
        book.setRatingsCount(Integer.parseInt(ratingsCount));
        book.setImageUrl(imageUrl);

        return book;
    }

    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";
//        Book book = APIResponseParser.parse(response);
        String[] startRule = {"<title>", "<name>", "<original_publication_year type=\"integer\">", "<average_rating>", "<ratings_count type=\"integer\">", "<image_url>"};
        String endRule = "<";
        Book book = APIResponseParser.parse(response, startRule, endRule);
        Log.logger.info("The book {} is written by {} in the year {} with average rating {} and ratings count {} and image url {}",
                book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getAverageRating(), book.getRatingsCount(), book.getImageUrl());
    }
}
