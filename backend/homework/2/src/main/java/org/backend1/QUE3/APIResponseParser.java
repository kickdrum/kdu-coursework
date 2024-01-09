package org.backend1.QUE3;
import java.util.logging.Logger;

public class APIResponseParser {

    private static final Logger LOGGER = Logger.getLogger(APIResponseParser.class.getName());

    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

        // Parse author
        startRule = "<name>";
//        String[] authorRules = {"<author>", startRule};
        String author = parse(response, startRule, endRule);
        book.setAuthor(author);

        // Parse publication year
        startRule = "<original_publication_year type=\"integer\">";
        String publicationYear = parse(response, startRule, endRule);
        book.setPublicationYear(Integer.parseInt(publicationYear));

        // Parse average rating
        startRule = "<average_rating>";
        String avgRating = parse(response, startRule, endRule);
        book.setAverageRating(Double.parseDouble(avgRating));

        // Parse ratings count
        startRule = "<ratings_count type=\"integer\">";
        String ratingsCount = parse(response, startRule, endRule);
        // Removing commas and converting to integer
        book.setRatingsCount(Integer.parseInt(ratingsCount.replaceAll(",", "")));

        // Parse image URL
        startRule = "<image_url>";
        String imageUrl = parse(response, startRule, endRule);
        book.setImageUrl(imageUrl);

        return book;
    }

    private static String parse(String response, String startRule, String endRule) {
        int startIndex = response.indexOf(startRule);
        if (startIndex != -1) {
            int endIndex = response.indexOf(endRule, startIndex + startRule.length());
            if (endIndex != -1) {
                return response.substring(startIndex + startRule.length(), endIndex);
            }
        }
        return null;
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


        Book apiParsedResult = APIResponseParser.parse(response);

        // Print the parsed book information using LOGGER.INFO
        if (apiParsedResult != null) {
            LOGGER.info("Parsed Book Information:");
            LOGGER.info("Title: " + apiParsedResult.getTitle());
            LOGGER.info("Author: " + apiParsedResult.getAuthor());
            LOGGER.info("Publication Year: " + apiParsedResult.getPublicationYear());
            LOGGER.info("Average Rating: " + apiParsedResult.getAverageRating());
            LOGGER.info("Ratings Count: " + apiParsedResult.getRatingsCount());
            LOGGER.info("Image URL: " + apiParsedResult.getImageUrl());
        } else {
            LOGGER.warning("Failed to parse book information.");
        }


    }
}