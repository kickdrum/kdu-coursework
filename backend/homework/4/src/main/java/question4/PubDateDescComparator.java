package question4;
import java.util.*;

public class PubDateDescComparator implements Comparator<Book>{
    public int compare(Book book1,Book book2){
        int desc=Integer.compare(book1.getYear(),book2.getYear());
        if(desc==0)
            return book1.compareTo(book2);
        return -desc;
    }

}

