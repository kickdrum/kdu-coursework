package kdu.homework;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[] array1 = new String[]{"a", "b", "c", "d", "e"};
        Integer[] array2 = new Integer[]{10, 20, 30, 40, 50};

        array1 = Swap.swap(array1, 0, 4);
        array2 = Swap.swap(array2, 0, 1);

        Logs logger = new Logs();

        logger.console(Arrays.toString(array1));
        logger.console("\n");

        logger.console(Arrays.toString(array2));
        logger.console("\n");

    }
}