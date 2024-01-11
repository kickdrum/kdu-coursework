package org.example;

public class Swap {
        public static <T> T[] swapping(T[] array, int ind1, int ind2) {
            T temp = array[ind1];
            array[ind1] = array[ind2];
            array[ind2] = temp;
            return array;
        }
    }

