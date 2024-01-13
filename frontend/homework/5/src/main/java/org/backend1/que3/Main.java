package org.backend1.que3;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args)
    {
        int number = 24;
        Factorial factorial = new Factorial(number);
        Factors factor = new Factors(number);

        factorial.start();
        factor.start();


        try {
            factorial.join();
            factor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LOGGER.info("Main thread Executed");
    }



}
