package question3;
import java.util.Arrays;

public class ExchangePositions {
    public static <T> void swapElements(T[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            System.out.println("Invalid input: Unable to swap elements.");
            return;
        }
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
