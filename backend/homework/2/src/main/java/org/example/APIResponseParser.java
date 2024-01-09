package org.example;

public class APIResponseParser {
    public static Book parse(String response) {
        Book book = new Book();

        String endRule = "<";
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

        startRule = "<name>";
        String[] multipleTagStartRule = {"\n <author>", startRule};
        endRule = "<";
        String author = parse(response, multipleTagStartRule, endRule);
        book.setAuthor(author);

        startRule = "<original_publication_year type=\"integer\">";
        endRule = "</original_publication_year>";
        String publicationYearStr = parse(response, startRule, endRule);
        Integer publicationYear = Integer.parseInt(publicationYearStr);
        book.setPublicationYear(publicationYear);

        startRule = "<average_rating>";
        endRule = "</average_rating>";
        String averageRatingStr = parse(response, startRule, endRule);
        Double averageRating = Double.parseDouble(averageRatingStr);
        book.setAverageRating(averageRating);

        startRule = "<ratings_count type=\"integer\">";
        endRule = "</ratings_count>";
        String ratingsCountStr = parse(response, startRule, endRule);
        Integer ratingsCount = Integer.parseInt(ratingsCountStr.replaceAll(",", ""));
        book.setRatingsCount(ratingsCount);

        startRule = "<image_url>";
        endRule = "</image_url>";
        String imageUrl = parse(response, startRule, endRule);
        book.setImageUrl(imageUrl);

        return book;
    }

    private static String parse(String response, String startRule, String endRule) {
        int startIndex = response.indexOf(startRule) + startRule.length();
        int endIndex = response.indexOf(endRule, startIndex);
        return response.substring(startIndex, endIndex).trim();
    }

    private static String parse(String response, String[] startRule, String endRule) {
        for (String tag : startRule) {
            int startIndex = response.indexOf(tag);
            if (startIndex != -1) {
                startIndex += tag.length();
                int endIndex = response.indexOf(endRule, startIndex);
                return response.substring(startIndex, endIndex).trim();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String response =
                "<work>" +
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
        "       </author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";

        Book parsedBook = APIResponseParser.parse(response);
        parsedBook.printBookDetails();

    }
}