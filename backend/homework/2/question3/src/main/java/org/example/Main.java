package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count ype=\"integer\">1,16,315</ratings_count>" +
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
        Book B1 = new Book();
        B1=APIResponseParser.parse(response);

        System.out.println("Title: " + B1.getTitle());
        System.out.println("Author: " + B1.getAuthor());
        System.out.println("Publication Year: " + B1.getPublicationYear());
        System.out.println("Average Rating: " + B1.getAverageRating());
        System.out.println("Ratings Count: " + B1.getRatingsCount());
        System.out.println("Image URL: " + B1.getImageUrl());

    }
}