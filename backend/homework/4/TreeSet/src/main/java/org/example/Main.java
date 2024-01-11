package org.example;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static Set<Book> treeSetDemo(Comparator<Book> comparator){
        Book book1 = new Book("Harry Potter","J.K.Rowling",1997);
        Book book2 = new Book("Effective Java","Joshua Bloch",2008);
        Book book3 = new Book("The Last Lecture","Randy Pausch",2008);
        Book book4 = new Book("Walden","Henry David Thoreau",1854);

        TreeSet<Book> treeSet = new TreeSet<>(comparator);
        treeSet.add(book1);
        treeSet.add(book2);
        treeSet.add(book3);
        treeSet.add(book4);

        return treeSet;

    }
    public static void printBooks(Set<Book> treeSet){
        StringBuilder stringBuilder =new StringBuilder();
        for (Book book:treeSet){
            stringBuilder.append(book);
        }
        Logging logging = new Logging();
        logging.logString(stringBuilder);

    }
    public static void main(String[] args) {
        Set<Book> ans1=treeSetDemo(null);
        printBooks(ans1);
        Set<Book> ans2=treeSetDemo(new PubDateAscComparator());
        printBooks(ans2);
        Set<Book> ans3=treeSetDemo(new PubDateDescComparator());
        printBooks(ans3);

    }
}