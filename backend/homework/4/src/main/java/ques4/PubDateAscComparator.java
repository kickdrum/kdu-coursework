package ques4;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Book> {
    /**
     *
     * @param book1
     * @param book2
     * @return
     */
    public int compare(Book book1,Book book2){
        int compareValue=Integer.compare(book1.getYear(),book2.getYear());

        if(compareValue==0)
            return book1.getTitle().compareTo(book2.getTitle());

        return compareValue;
    }
}
