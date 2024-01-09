package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//class BookLogger {
//    static final Logger logger = LoggerFactory.getLogger(BookLogger.class);
//    public static Logger getLogger()
//    {
//        return logger;
//    }
//}

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private double averageRating;
    private int ratingsCount;
    private String imageUrl;

    public Book() {
    }

    public Book(String title, String author, int publicationYear, double averageRating, int ratingsCount, String imageUrl) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.averageRating = averageRating;
        this.ratingsCount = ratingsCount;
        this.imageUrl = imageUrl;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public void printBookDetails() {
        LoggerClass.getLoggerOutput().info("Title: {}", getTitle() != null ? getTitle() : "N/A");
        LoggerClass.getLoggerOutput().info("Author name: {}", getAuthor() != null ? getAuthor() : "N/A");
        LoggerClass.getLoggerOutput().info("Average rating: {}", getAverageRating());
        LoggerClass.getLoggerOutput().info("Ratings count: {}", getRatingsCount());
        LoggerClass.getLoggerOutput().info("Publication year: {}", getPublicationYear());
        LoggerClass.getLoggerOutput().info("Image URL: {}", getImageUrl() != null ? getImageUrl() : "N/A");
    }




}