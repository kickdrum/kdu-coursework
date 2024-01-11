package org.example.question4;

import java.util.Comparator;

class pubdateasccomparator implements Comparator {

    public int compare(Object o1, Object o2) {
        if (((book)o1).getYear() == ((book)o2).getYear()) {
            return ((book)o1).getTitle().compareTo(((book)o2).getTitle());
        } else if (((book)o1).getYear() < ((book)o2).getYear()) {
            return -1;
        } else {
            return 1;
        }
    }
}
