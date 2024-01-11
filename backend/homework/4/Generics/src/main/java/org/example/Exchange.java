package org.example;

public class Exchange {

    public static <T> void swap (T[] array, int index1 ,int index2){
        if (index1 >= 0 && index1 < array.length && index2 >= 0 && index2 < array.length) {
            T temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        } else {
            System.out.println("Invalid indices for swapping");
        }

    }
}
