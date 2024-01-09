package shrishti.example.q3;
import java.awt.*;

public class APIResponseParser {

    public static String parse(String response, String startRule, String endRule) {
        int startIndex = response.indexOf(startRule); // starting index
        int endIndex = response.indexOf(endRule, startIndex);
        int startPoint = startRule.length() + startIndex;
        int lengthOfData = endIndex - startPoint;
        return (startIndex != -1 && endIndex != -1)
                ? response.substring(startPoint, startPoint + lengthOfData)
                : null;
    }
    public static Book parse(String response) {
        Book book = new Book();

        String title = parse(response, "<title>", "</title>");
        book.setTitle(title);
        String author = parse(response, "<name>", "</name>");
        book.setAuthor(author);
        int publicationYear = Integer.parseInt(
                parse(response, "<original_publication_year type=\"integer\">", "</original_publication_year>"));
        book.setPublicationYear(publicationYear);
        double avgRating = Double.parseDouble(parse(response, "<average_rating>", "</average_rating").replace(",", ""));
        book.setAverageRating(avgRating);
        int ratingCount = Integer
                .parseInt(parse(response, "<ratings_count type=\"integer\">", "</ratings_count>").replaceAll(",", ""));
        book.setRatingsCount(ratingCount);
        String imageUrl = parse(response, "<image_url>", "</image_url");
        book.setImageUrl(imageUrl);
        return book;
    }

    // .replace commas and parse int


    public static void main(String[] args) {
        String response = "<work>\n" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>\n" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>\n" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count> " +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/> " +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>\n" +
                "<best_book type=\"Book\">\n" +
                "<id type=\"integer\">16902</id> <title>Walden</title> <author>\n" +
                "<id type=\"integer\">10264</id>\n" +
                "<name>Henry David Thoreau</name> </author>\n" +
                "<image_url>http://images.gr-assets.com/books/1465675526m/16902.jpg</image_url>\n" +
                "<small_image_url>http://images.gr-assets.com/books/1465675526s/16902.jpg</small\n" +
                "</small_image_url>\n" +
                "</best_book>\n" +
                "</work>";
          APIResponseParser.parse(response);

    }
}
