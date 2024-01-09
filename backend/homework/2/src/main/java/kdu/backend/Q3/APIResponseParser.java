package kdu.backend.Q3;

import java.util.logging.Logger;

public class APIResponseParser {
    private static final Logger logger = Logger.getLogger(APIResponseParser.class.getName());

    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

        // Parsing the name of the author
        String[] startAuthorRule = {"<author>","<name>"};
        String authorName = parse(response, startAuthorRule,"</name>");
        book.setAuthor(authorName);

        // Parsing the publication year
        String startYearRule = "<original_publication_year type=\"integer\">";
        int publicationYear = Integer.parseInt(parse(response, startYearRule, "</original_publication_year>"));
        book.setPublicationYear(publicationYear);

        // Parsing the average rating
        String startRatingRule = "<average_rating>";
        double averageRating = Double.parseDouble(parse(response, startRatingRule, "</average_rating>"));
        book.setAverageRating(averageRating);

        // Parsing the count of ratings
        String startRatingsCountRule = "<ratings_count type=\"integer\">";
        String ratingsCountString = parse(response, startRatingsCountRule, "</ratings_count>");
        int ratingsCount = Integer.parseInt(ratingsCountString.replaceAll(",", ""));
        book.setRatingsCount(ratingsCount);

        // Parsing the image URL
        String startImageUrlRule = "<image_url>";
        String imageUrl = parse(response, startImageUrlRule, "</image_url>");
        book.setImageUrl(imageUrl);

        logger.info("Book parsed successfully: " + book);

        return book;
    }

    private static String parse(String response, String startRule, String endRule) {
        int startIndex = response.indexOf(startRule) + startRule.length();
        int endIndex = response.indexOf(endRule, startIndex);
        return response.substring(startIndex, endIndex);
    }

    private static String parse(String response, String[] startRules, String endRule) {
        int startIndex = response.indexOf(startRules[0]);
        for (int i = 1; i < startRules.length; i++) {
            startIndex = response.indexOf(startRules[i], startIndex);
        }
        startIndex += startRules[startRules.length - 1].length();

        int endIndex = response.indexOf(endRule, startIndex);
        return response.substring(startIndex, endIndex);
    }

    public static void main(String[] args) {
        String response = "<work>" + "<id type=\"integer\">2361393</id>" + "<books_count type=\"integer\">813</books_count>" + "<ratings_count type=\"integer\">1,16,315</ratings_count>" + "<text_reviews_count type=\"integer\">3439</text_reviews_count>" + "<original_publication_year type=\"integer\">1854</original_publication_year>" + "<original_publication_month type=\"integer\" nil=\"true\"/>" + "<original_publication_day type=\"integer\" nil=\"true\"/>" + "<average_rating>3.79</average_rating>" + "<best_book type=\"Book\">" + "<id type=\"integer\">16902</id>" + "<title>Walden</title>" + "<author>" + "<id type=\"integer\">10264</id>" + "<name>Henry David Thoreau</name>" + "</author>" + "<image_url>" + "http://images.gr-assets.com/books/1465675526m/16902.jpg" + "</image_url>" + "<small_image_url>" + "http://images.gr-assets.com/books/1465675526s/16902.jpg" + "</small_image_url>" + "</best_book>" + "</work>";
        Book book = APIResponseParser.parse(response);

        // Logging the info of book
        logger.info("Book Information:- ");
        logger.info("Title of book:- " + book.getTitle());
        logger.info("Author of book:- " + book.getAuthor());
        logger.info("Publication Year of the book:- " + book.getPublicationYear());
        logger.info("Average Rating of the book:- " + book.getAverageRating());
        logger.info("Ratings Count of the book:- " + book.getRatingsCount());
        logger.info("Image URL of the book:-" + book.getImageUrl());
    }
}
