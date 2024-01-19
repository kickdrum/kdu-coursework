package org.example;

class ClassCompare implements java.util.Comparator<Pair> {
    @Override
    public int compare(Pair a, Pair b) {
        return b.getValue() - a.getValue();
    }
}
