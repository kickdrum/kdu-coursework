package org.example.question4;

public class Main {
    public static void main(String[] args) {
        setdemo.treeSetDemo(null);

        // Using PubDateAscComparator

        setdemo.treeSetDemo(new pubdateasccomparator());

        // Using PubDateDescComparator
        setdemo.treeSetDemo(new pubdatedesccomparator());
    }
}
