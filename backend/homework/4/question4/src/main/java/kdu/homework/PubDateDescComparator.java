package kdu.homework;
import java.util.Comparator;

public class PubDateDescComparator implements Comparator<Book>{

    public int compare(Book book1, Book book2)
    {
        if(book1.getYear() != book2.getYear()){
            return -(book1.getYear() - book2.getYear());
        }

        return (book1.getTitle()).compareTo(book2.getTitle());
    }
}
