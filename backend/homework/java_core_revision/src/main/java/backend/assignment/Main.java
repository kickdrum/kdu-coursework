package backend.assignment;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Author janeAusten = new Author("Jane Austen");
        Author andyWeir = new Author("Andy Weir");
        Author suzanneCollins = new Author("Suzanne Collins");
        Author author1 = new Author("J.R.R. Tolkien");

        Book book1 = new Book("The Lord of the Rings", "1234567890","adventure");
        Book prideAndPrejudice = new Book("Pride and Prejudice", "9781402803505","Romance");
        Book theMartian = new Book("The Martian", "9780552151307","Science Fiction");
        Book theHungerGames = new Book("The Hunger Games", "9780545219262","Dystopian Fiction");


        Patron patron1 = new Patron("Alice", 3);
        Patron johnDoe = new Patron("John Doe", 3);
        Patron janeSmith = new Patron("Jane Smith", 5);
        Patron michaelChen = new Patron("Michael Chen", 2);

        library.addBook(prideAndPrejudice);
        library.addBook(book1);
        library.addBook(theMartian);
        library.addBook(theHungerGames);

        library.addAuthor(author1);
        library.addAuthor(suzanneCollins);
        library.addAuthor(janeAusten);
        library.addAuthor(andyWeir);

        library.addPatron(patron1);
        library.addPatron(johnDoe);
        library.addPatron(janeSmith);
        library.addPatron(michaelChen);

        library.checkOutBook(theHungerGames, johnDoe);
        List<Book> availableBooks = library.findAllAvailableBooks();
        List<Book> booksByAuthor = library.findBooksByAuthor(janeAusten);
        List<Book> overdueBooks = library.findOverdueBooks();
        List<Book> popularBooks = library.findPopularBooks(3);
        Map<String, List<Book>> booksByGenre = library.groupBooksByGenre();

        LogBack.infoLogger("Available Books:");
        for(Book book:availableBooks){
            LogBack.infoLogger(book.getTitle());
        }

        LogBack.infoLogger("Books by Author (Jane Austen):");
        for(Book book: booksByAuthor){
            LogBack.infoLogger(book.getTitle());
        }

        LogBack.infoLogger("Overdue Books: ");
        for(Book book: overdueBooks){
            LogBack.infoLogger(book.getTitle());
        }

        LogBack.infoLogger("Top 3 Popular Books: ");
        for(Book book: popularBooks){
            LogBack.infoLogger(book.getTitle());
        }

        LogBack.infoLogger("Books by Genre (Science Fiction): ");
        Collection<List<Book>> booksInGenre = booksByGenre.values();
        for( List<Book> listOfbook: booksInGenre){
            for(Book book : listOfbook) {
                LogBack.infoLogger(book.getTitle());
            }
        }
    }
}