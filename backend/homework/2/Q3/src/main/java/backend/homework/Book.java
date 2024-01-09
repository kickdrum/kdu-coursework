package backend.homework;

public class Book {
    /**
     * The title of the book.
     */
    private String title;

    /**
     * The author of the book.
     */
    private String author;

    /**
     * The year the book was published.
     */
    private int publicationYear;

    /**
     * The average rating of the book, based on user ratings.
     */
    private double averageRating;

    /**
     * The total number of ratings the book has received.
     */
    private int ratingsCount;

    /**
     * The URL of the book's cover image.
     */
    private String imageUrl;


    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The new title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The new author of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the publication year of the book.
     *
     * @return The publication year of the book.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Sets the publication year of the book.
     *
     * @param publicationYear The new publication year of the book.
     */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Gets the average rating of the book.
     *
     * @return The average rating of the book.
     */
    public double getAverageRating() {
        return averageRating;
    }

    /**
     * Sets the average rating of the book.
     *
     * @param averageRating The new average rating of the book.
     */
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    /**
     * Gets the number of ratings the book has received.
     *
     * @return The number of ratings the book has received.
     */
    public int getRatingsCount() {
        return ratingsCount;
    }

    /**
     * Sets the number of ratings the book has received.
     *
     * @param ratingsCount The new number of ratings the book has received.
     */
    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    /**
     * Gets the URL of the book's cover image.
     *
     * @return The URL of the book's cover image.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the URL of the book's cover image.
     *
     * @param imageUrl The new URL of the book's cover image.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}