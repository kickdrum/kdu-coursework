package org.student;

import org.student.library.Author;
import org.student.library.Book;
import org.student.library.Library;
import org.student.library.Patron;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Catcher in the Rye", "978-0-316-76948-0","Fiction");
        Book book2 = new Book("To Kill a Mockingbird", "978-0-06-112008-4","Thriller");
        Book book3 = new Book("1984", "978-0-452-28423-4","Action");
        Book book4 = new Book("Pride and Prejudice", "978-0-486-32698-9","Political");
        Book book5 = new Book("Harry Potter","978-0-133-13323-9","Fiction");

        Author author1 = new Author("J.D. Salinger");
        Author author2 = new Author("Harper Lee");
        Author author3 = new Author("George Orwell");
        Author author4 = new Author("Harper Lee");
        Author author5 = new Author("J.K. Rowlings");

        author1.getBooks().add(book1);
        author2.getBooks().add(book2);
        author3.getBooks().add(book3);
        author4.getBooks().add(book4);
        author5.getBooks().add(book5);

        library.getAuthors().add(author1);
        library.getAuthors().add(author2);
        library.getAuthors().add(author3);
        library.getAuthors().add(author4);
        library.getAuthors().add(author5);

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        Patron patron1 = new Patron("Alice", 3);
        Patron patron2 = new Patron("Bob", 2);

        library.getPatrons().add(patron1);
        library.getPatrons().add(patron2);

        Menu.displayMenu(library);

    }
}