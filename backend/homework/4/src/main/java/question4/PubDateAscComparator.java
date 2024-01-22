package question4;
import java.util.*;

public class PubDateAscComparator implements Comparator<Book>{
    public int compare(Book book1,Book book2){
        int asc=Integer.compare(book1.getYear(),book2.getYear());
        if(asc==0)
            return book1.compareTo(book2);
        return asc;
    }
}
