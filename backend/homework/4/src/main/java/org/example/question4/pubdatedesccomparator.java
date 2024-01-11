package org.example.question4;

import java.util.Comparator;

class pubdatedesccomparator implements Comparator<book> {
    @Override
    public int compare(book book1, book book2) {
        if (book1.getYear() == book2.getYear()) {
            return book1.getTitle().compareTo(book2.getTitle());
        } else {
            return Integer.compare(book2.getYear(), book1.getYear());
        }
    }
}