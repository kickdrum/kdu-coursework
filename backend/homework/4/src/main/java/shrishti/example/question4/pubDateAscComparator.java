package shrishti.example.question4;
import java.util.Comparator;
public class pubDateAscComparator implements Comparator <book> {
    @Override
    public int compare(book book1, book book2){
        int smaller = Integer.compare(book1.getYear(), book2.getYear());
        if(smaller==0){
            smaller= book1.compareTo(book2);
        }
        return smaller;
    }

}
