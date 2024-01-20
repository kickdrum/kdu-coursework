package org.example;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static List<Book> initializeBooks() {
        Book b1 = new Book("The Great Gatsby", 1234, false, "Fiction");
        Book b2 = new Book("The Great Gatsby", 1234, false, "Fiction");
        Book b3 = new Book("The Great Gatsby", 1234, false, "Fiction");
        Book b4 = new Book("The Grapes of Wrath", 2345, false, "Fiction");
        Book b5 = new Book("The Scarlet Letter", 3456, false, "Horror");
        Book b6 = new Book("The Scarlet Letter", 3456, false, "Horror");
        Book b7 = new Book("The Scarlet Letter", 3456, false, "Horror");
        Book b8 = new Book("The Scarlet Letter", 3456, false, "Horror");
        Book b9 = new Book("The Catcher in the Rye", 4567, false, "Fiction");
        Book b10 = new Book("The Color Purple", 5678, false, "Fantasy");
        Book b11 = new Book("The Color Purple", 5678, false, "Fantasy");
        Book b12 = new Book("The Color Purple", 5678, false, "Fantasy");
        Book b13 = new Book("The Sun Also Rises", 6789, false, "Fiction");
        Book b14 = new Book("The Sun Also Rises", 6789, false, "Fiction");
        Book b15 = new Book("The Sound and the Fury", 7890, false, "Science and Magic");
        Book b16 = new Book("The Sound and the Fury", 7890, false, "Science and Magic");
        Book b17 = new Book("The Sound and the Fury", 7890, false, "Science and Magic");
        Book b18 = new Book("The Sound and the Fury", 7890, false, "Science and Magic");
        List<Book> books = List.of(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18);
        return books;

    }

    private static List<Author> initializeAuthors(List<Book> books) {
        Author a1 = new Author("F. Scott Fitzgerald", List.of(books.get(0), books.get(4)));
        Author a2 = new Author("John Steinbeck", List.of(books.get(3), books.get(9)));
        Author a3 = new Author("J.D. Salinger", List.of(books.get(8)));
        Author a4 = new Author("Ernest Hemingway", List.of(books.get(12), books.get(14)));
        List<Author> authors = List.of(a1, a2, a3, a4);
        return authors;
    }

    private static List<Patron> initializePatrons() {
        Patron p1 = new Patron("John Doe", 3);
        Patron p2 = new Patron("Mark Wood", 6);
        Patron p3 = new Patron("Jane Doe", 3);
        Patron p4 = new Patron("Mary Jane", 6);
        Patron p5 = new Patron("John Smith", 3);
        Patron p6 = new Patron("Ashley Wood", 2);

        List<Patron> patrons = List.of(p1, p2, p3, p4, p5, p6);
        return patrons;
    }

    public static void main(String[] args) {
        List<Book> books = initializeBooks();
        List<Author> authors = initializeAuthors(books);
        List<Patron> patrons = initializePatrons();
        Library library = new Library(books, authors, patrons);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Library Management System!");
        boolean exit = false;
        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. List all available books");
            System.out.println("2. Check out a book");
            System.out.println("3. Return a book");
            System.out.println("4. List all books by author");
            System.out.println("5. List all overdue books");
            System.out.println("6. List all books based on genre");
            System.out.println("7. List top N books");
            System.out.println("8. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Listing all available books:");
                    library.findAllAvailableBooks();
                    break;
                case 2:
                    System.out.println("Checking out a book:");
                    System.out.println("Please enter the isbn of the book you want to check out:");
                    Integer isbn = scanner.nextInt();
                    System.out.println("Please enter your name:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println(name);
                    library.checkOutBook(isbn, name);
                    break;
                case 3:
                    System.out.println("Returning a book:");
                    System.out.println("Please enter the isbn of the book you want to return:");
                    Integer isbn2 = scanner.nextInt();
                    System.out.println("Please enter your name:");
                    scanner.nextLine();
                    String name2 = scanner.nextLine();
                    System.out.println(name2);
                    library.returnBook(isbn2, name2);
                    break;
                case 4:
                    System.out.println("Listing all books by author:");
                    System.out.println("Please enter the name of the author:");
                    scanner.nextLine();
                    String author = scanner.nextLine();
                    library.findBooksByAuthor(author);
                    break;
                case 5:
                    System.out.println("Listing all overdue books:");
                    library.findOverdueBooks();
                    break;
                case 6:
                    System.out.println("Listing all books based on genre:");
                    Map<String, List<Book>> genreMap = library.groupBooksByGenre();
                    genreMap.forEach((genre, bookList) -> {
                        System.out.println(genre);
                        bookList.forEach(book -> System.out.println(book.getTitle()));
                    });
                    break;
                case 7:
                    System.out.println("Listing top N books:");
                    System.out.println("Please enter N:");
                    int N = scanner.nextInt();
                    library.findPopularBooks(N);
                    break;
                case 8:
                    System.out.println("Exiting Library Management System...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

    }
}