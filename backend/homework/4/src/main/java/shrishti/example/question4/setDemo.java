package shrishti.example.question4;
import shrishti.example.Logger.logger;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class setDemo {

    public static Set<book> treeSetDemo(Comparator<book> comparator){
        book book1=new book("Effective Java","Joshua Bloch", 2008);
        book  book2=new book("Harry Potter","J.K.Rowling", 1997);
        book  book3=new book("The Last Lecture","Randy Pausch", 2008);
        book book4= new book("Walden", "author=Henry David Thoreau",1854);

            Set<book> books;
            if(comparator == null){
                books = new TreeSet<>();
            }else{
                books=new TreeSet<>(comparator);
            }
            books.add(book1);
            books.add(book2);
            books.add(book3);
            books.add(book4);

                for(book result :books){
                    System.out.println(String.valueOf(result));
                }
                return books;

    }
    public static void main(String[] args) {
        treeSetDemo(null);
        logger.printLogger("Book sorted in Ascending Order :");
        treeSetDemo(new pubDateAscComparator());

        logger.printLogger("Book sorted in Descending Order :");
        treeSetDemo(new pubDateDescComparator());
    }
}
