package org.student;

import org.student.library.Author;
import org.student.library.Book;
import org.student.library.Library;
import org.student.library.Patron;
import org.student.logger.Logging;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Menu(){}
    public static void displayMenu(Library lb){
        Scanner sc = new Scanner(System.in);
        boolean go = true;
        while(go){
            Logging.logInfo("===== Library Menu =====");
            Logging.logInfo("1. Display all available books");
            Logging.logInfo("2. Check out a book");
            Logging.logInfo("3. Display books by author");
            Logging.logInfo("4. Display overdue books");
            Logging.logInfo("5. Display popular books");
            Logging.logInfo("6. Group books by genre");
            Logging.logInfo("0. Exit");

            int opt = sc.nextInt();

            switch (opt){
                case 1 : {
                    List<Book> books = lb.findAllAvailableBooks();
                    for(Book book : books){
                        Logging.logInfo(book.getTitle());
                    }
                    break;
                }
                case 2 : {
                    Logging.logInfo("Enter book to checkout and Name of patron");
                    String bookName = sc.next();
                    String patronName = sc.next();

                    Book book = lb.findBook(bookName);
                    Patron patron = lb.findPatron(patronName);

                    lb.checkOutBook(book,patron);
                    break;
                }
                case 3 : {
                    Logging.logInfo("Enter name of author");
                    sc.nextLine();
                    String authorName = sc.nextLine();
                    Logging.logInfo(authorName);

                    Author author = lb.findAuthor(authorName);
                    List<Book> books = lb.findBooksByAuthor(author);

                    for(Book book : books){
                        Logging.logInfo(book.getTitle());
                    }
                    break;
                }
                case 4 : {
                    List<Book> overdue = lb.findOverdueBooks();
                    for(Book book : overdue){
                        Logging.logInfo(book.getTitle());
                    }
                    break;
                }
                case 5 : {
                    List<Book> popular = lb.findPopularBooks(2);
                    for(Book book : popular){
                        Logging.logInfo(book.getTitle());
                    }
                    break;
                }
                case 6: {
                    Map<String, List<Book>> genreMap = lb.groupBooksByGenre();

                    for (Map.Entry<String, List<Book>> entry : genreMap.entrySet()) {
                        String genre = entry.getKey();
                        List<Book> books = entry.getValue();

                        Logging.logInfo("Books in Genre: ".concat(genre));
                        for (Book book : books) {
                            Logging.logInfo(book.getTitle());
                        }
                    }
                    break;
                }
                default: {
                    go = false;
                    break;
                }
            }

        }
    }
}
