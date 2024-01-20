package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Patron> patrons = new ArrayList<>(); // Patron is a borrower
    private List<Book> checkedOutBooks = new ArrayList<>(); // each Book can have multiple copies

    // Implement methods for checking out, returning books, managing patrons, etc.
    public Library(List<Book> books, List<Author> authors, List<Patron> patrons) {
        this.books = books;
        this.authors = authors;
        this.patrons = patrons;
        this.checkedOutBooks = null;
    }

    public void findAllAvailableBooks() {
//        list books with name and quantity
        Map<String, Integer> booksName = new HashMap<>();
        for (Book book : books) {
            if (!booksName.containsKey(book.getTitle())) {
                booksName.put(book.getTitle(), 1);
            } else {
                booksName.put(book.getTitle(), booksName.get(book.getTitle()) + 1);
            }
        }

        booksName.forEach((title, quantity) -> {
            System.out.println(title);
        });
    }

    public void checkOutBook(int isbn, String name) {
        Book book = books.stream()
                .filter(b -> b.getIsbn()==isbn)
                .findFirst()
                .orElse(null);
        if(book == null){
            System.out.println("Book not found");
            return;
        }
        //print patrons
        patrons.stream()
                .forEach(patron -> System.out.println(patron.getName()));
        Patron patron = patrons.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if(patron == null){
            System.out.println("Patron not found");
            return;
        }
        System.out.println(patron.getName());
        if (patron.getCheckedOutBooks().size() >= patron.getCheckoutLimit()) {
            System.out.println("Sorry, you have reached your checkout limit.");
        } else {
            book.setCheckedOut(true);
            book.setCheckedOutCount(book, book.getCheckedOutCount() + 1);
            patron.getCheckedOutBooks().add(book);
            checkedOutBooks.add(book);
            System.out.println("You have successfully checked out " + book.getTitle());
        }
    }

public void returnBook(int isbn, String name) {
    Book book = books.stream()
            .filter(b -> b.getIsbn()==isbn)
            .findFirst()
            .orElse(null);

    Patron patron = patrons.stream()
            .filter(p -> p.getName().equals(name))
            .findFirst()
            .orElse(null);
    assert book != null;
    if (book.getCheckedOutCount() == 0) {
            book.setCheckedOut(false);
            assert patron != null;
            patron.getCheckedOutBooks().remove(book);
        }
    book.setCheckedOutCount(book, book.getCheckedOutCount() - 1);
    System.out.println("You have successfully returned " + book.getTitle());
    }

    public void findBooksByAuthor(String name) {
        Author author = authors.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst()
                .orElse(null);
        author.getBooks().stream()
                .forEach(book -> System.out.println(book.getTitle()));
    }

    public List<Book> findOverdueBooks() {
        List<Book> overdueBooks = new ArrayList<>();
        for (Book book : checkedOutBooks) {
            if (book.isCheckedOut()) {
                overdueBooks.add(book);
            }
        }
        return overdueBooks;
    }

    public void findPopularBooks(int N) {
        books.stream()
                .filter(book -> book.getCheckedOutCount() > N)
                .forEach(book -> System.out.println(book.getTitle()));
    }

    public Map<String, List<Book>> groupBooksByGenre() {
        Map<String, List<Book>> genreMap = new HashMap<>();
        for (Book book : books) {
            if (!genreMap.containsKey(book.getGenre())) {
                genreMap.put(book.getGenre(), new ArrayList<>());
            }
            genreMap.get(book.getGenre()).add(book);
        }
        return genreMap;
    }

}