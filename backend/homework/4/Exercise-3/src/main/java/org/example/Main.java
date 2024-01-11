package org.example;

import org.example.logging.LoggingSystem;

public class Main {
    public static void main(String[] args) {
        final LoggingSystem ls = new LoggingSystem();
        String[] list1={"a","b","c","d"};
        Double[] list2={1.2,2.3,3.4,4.5,5.6};
        String[] updatedlist=Swap.swapping(list1,1,3);
        Double[] updatedlist2=Swap.swapping(list2,3,5);
        for(String i:updatedlist){
            ls.logInfo(i);
        }
        for(Double i:updatedlist2){
            ls.logInfo(String.valueOf(i));
        }
    }
}