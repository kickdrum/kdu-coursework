package backend.homework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parses API responses containing book information and extracts relevant data.
 *
 * @author [Your Name]
 */
public class APIResponseParser {
    /**
     * Logger for logging parsing events.
     */
    public static final Logger logger = LoggerFactory.getLogger(APIResponseParser.class);
    /**
     * Parses the input text and returns a Book instance containing
     * the parsed data.
     *
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */
    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

        // Parse author name
        startRule = "<name>";
        String authorName = parse(response, startRule, endRule);
        book.setAuthor(authorName);


        // Parse publication year
        startRule ="<original_publication_year type=\"integer\">";
        String  publicationYear = parse(response,startRule , endRule);
        System.out.println(publicationYear);
        book.setPublicationYear(Integer.parseInt(publicationYear));

        // Parse average rating
        startRule = "<average_rating>";
        double averageRating = Double.parseDouble(parse(response, startRule, endRule));
        book.setAverageRating(averageRating);

        // Parse ratings count (removing commas)
        startRule = "<ratings_count type=\"integer\">";
        int ratingsCount = Integer.parseInt(parse(response, startRule, endRule).replace(",", ""));
        book.setRatingsCount(ratingsCount);

        // Parse image URL
        startRule = "<image_url>";
        String imageUrl = parse(response, startRule, endRule);
        book.setImageUrl(imageUrl);

        return book;
    }

    /**
     * Extracts a substring between specified start and end rules within the response text.
     *
     * @param response the text to search within
     * @param startRule the starting rule/tag
     * @param endRule the ending rule/tag
     * @return the extracted substring, or null if not found
     */
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
                "<id type=\"integer\">2361393</id>" + "<books_count type=\"integer\">813</books_count>" + "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" + "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" + "<author>" + "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" + "<image_url>" + "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" + "<small_image_url>" + "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" + "</best_book>" + "</work>";

        Book responseBook = APIResponseParser.parse(response);

        if(responseBook!=null){
            logger.info("Book titile: "+responseBook.getTitle());
            logger.info("Book author: "+responseBook.getAuthor());
            logger.info("Book publication year: "+ responseBook.getPublicationYear());
            logger.info("Book average rating: "+ responseBook.getAverageRating());
            logger.info("Book ratings count: "+ responseBook.getRatingsCount());

        } else  {
            logger.error("Failed to Parse!");
        }
    }


}
