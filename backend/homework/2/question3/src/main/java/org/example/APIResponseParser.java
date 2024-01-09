package org.example;
import java.util.Arrays;

public class APIResponseParser {

    public static Book parse(String response) {
        Book book = new Book();

        // Parse title
        String endRule = "<";
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

        // Parse author
        startRule = "<name>";
        String author = parse(response, startRule, endRule);
        book.setAuthor(author);


        // Parse publication year
        startRule = "<original_publication_year type=\"integer\">";
        int publicationYear = parseInteger(response, startRule, endRule);
        book.setPublicationYear(publicationYear);

        // Parse average rating
        startRule = "<average_rating>";
        double averageRating = parseDouble(response, startRule, endRule);
        book.setAverageRating(averageRating);

        // Parse ratings count
        startRule = "<ratings_count type=\"integer\">";
        int ratingsCount = parseInteger(response, startRule, endRule);
        book.setRatingsCount(ratingsCount);

        // Parse image URL
        startRule = "<image_url>";
        String imageUrl = parse(response, startRule, endRule);
        book.setImageUrl(imageUrl);

        return book;
    }

    private static String parse(String response, String startRule, String endRule) {
        int startIndex = response.indexOf(startRule) + startRule.length();
        int endIndex = response.indexOf(endRule, startIndex);
        return response.substring(startIndex, endIndex);
    }

    private static int parseInteger(String response, String startRule, String endRule) {
        String value = parse(response, startRule, endRule);
        value = value.replaceAll(",", ""); // it will Remove commas from numbers
        return Integer.parseInt(value);
    }

    private static double parseDouble(String response, String startRule, String endRule) {
        String value = parse(response, startRule, endRule);
        return Double.parseDouble(value);
    }
}
