package backend.handson.q3;

import backend.handson.LogBack;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MultiThreadedFactorialFactors {

    /**
     * Calculates the factorial of a non-negative integer.
     *
     * @param number The non-negative integer for which to calculate the factorial.
     * @return The factorial of the given number, or 1 if the number is 0.
     * @throws IllegalArgumentException If the number is negative.
     */
    public static int calculateFactorial(int number){
        if(number == 0){
            return 1;
        }
        int factorial = 1;
        for (int i=2 ; i<= number; i++){
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Calculates all positive factors of a given integer.
     *
     * @param number The integer for which to find factors.
     * @return A list containing all positive factors of the given number, in ascending order.
     * @throws IllegalArgumentException If the number is negative.
     */
    public static List<Integer> calculateFactors(int number){
        List<Integer> factors = new ArrayList<>();
        for(int i=1; i<=number ;i++){
            if(number % i ==0){
                factors.add(i);
            }
        }
        return factors;
    }

    public static void main(String[] args){
        int number = 10;
        LogBack.outputLogger("Input Number is 10","INFO");

        Thread factorialThread = new Thread(()-> LogBack.outputLogger(Integer.toString(calculateFactorial(number)),"INFO"),"Factorial");
        factorialThread.start();

        Thread factorsThread = new Thread(()-> LogBack.outputLogger(calculateFactors(number).stream().map(Objects::toString).collect(Collectors.joining(",")), "INFO"),"Factors");
        factorsThread.start();
    }
}
