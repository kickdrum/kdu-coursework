package backend.hw4.comparator;

import java.util.Comparator;

//Comparator for ascending

public class PubDataAscComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        int yearOfComparison = Integer.compare(book1.getYear(),book2.getYear());
        if(yearOfComparison != 0 ) {
            return yearOfComparison;
        }
        return book1.compareTo(book2);
    }
}
