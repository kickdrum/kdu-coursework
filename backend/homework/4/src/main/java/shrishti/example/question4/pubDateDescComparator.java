package shrishti.example.question4;

import java.util.Comparator;
public class pubDateDescComparator implements Comparator <book> {
    @Override
    public int compare(book book1, book book2){
        int greater = Integer.compare(book2.getYear(), book1.getYear());
        if(greater==0){
            greater = book1.getTitle().compareTo(book2.getTitle());
        }
        return greater;
    }

}
