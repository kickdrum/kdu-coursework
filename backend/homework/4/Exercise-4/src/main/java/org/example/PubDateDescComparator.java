package org.example;


import java.util.Comparator;
public class PubDateDescComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        int result = Integer.compare(book2.getYear(), book1.getYear());
        if (result == 0) {
            result = book1.getTitle().compareTo(book2.getTitle());
        }
        return result;
    }
}
