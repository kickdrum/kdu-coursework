package kdu.homework;

public class Swap {

    private Swap(){
    }

    static <T> T[] swap(T[] array, int position1, int position2){

        T temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;

        return array;
    }
}
