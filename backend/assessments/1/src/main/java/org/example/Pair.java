package org.example;

public class Pair{
    String name;
    int value;
    Pair(String name,int value){
        this.name =name;
        this.value =value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}