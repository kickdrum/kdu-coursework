package org.example;

public class APIResponseParser {
    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

        // Extract other fields and set them in the Book instance
        book.setAuthor(parse(response, "<name>", endRule));
        book.setPublicationYear(parseInteger(response, "<original_publication_year type=\"integer\">", endRule));
        book.setAverageRating(parseDouble(response, "<average_rating>", endRule));
        book.setRatingsCount(parseInteger(response, "<ratings_count type=\"integer\">", endRule));
        book.setImageUrl(parse(response, "<image_url>", endRule));

        return book;
    }

    // Overloaded parse method with 3 parameters: response, startRule, endRule
    private static String parse(String response, String startRule, String endRule) {
        int startIndex = response.indexOf(startRule) + startRule.length();
        int endIndex = response.indexOf(endRule, startIndex);
        return response.substring(startIndex, endIndex).trim();
    }

    // Helper method to parse integer and remove commas
    private static int parseInteger(String response, String startRule, String endRule) {
        String result = parse(response, startRule, endRule);
        return Integer.parseInt(result.replace(",", ""));
    }

    // Helper method to parse double
    private static double parseDouble(String response, String startRule, String endRule) {
        return Double.parseDouble(parse(response, startRule, endRule));
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
        Book parsedBook = APIResponseParser.parse(response);

        // Print the parsed book details
        System.out.println("Title: " + parsedBook.getTitle());
        System.out.println("Author: " + parsedBook.getAuthor());
        System.out.println("Publication Year: " + parsedBook.getPublicationYear());
        System.out.println("Average Rating: " + parsedBook.getAverageRating());
        System.out.println("Ratings Count: " + parsedBook.getRatingsCount());
        System.out.println("Image URL: " + parsedBook.getImageUrl());
    }
}
