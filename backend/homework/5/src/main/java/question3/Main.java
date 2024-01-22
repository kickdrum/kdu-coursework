package question3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main{

    static final Logger slf4jLogger = LoggerFactory.getLogger(question2.Main.class);

    public static void main(String[] args) {
        int inputNumber = 6;

        Factorial factorialThread = new Factorial(inputNumber);
        Factors factorsThread = new Factors(inputNumber);

        factorialThread.start();
        factorsThread.start();

        try {
            factorialThread.join();
            factorsThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        slf4jLogger.info("Factorial of " + inputNumber + ": " + factorialThread.getFactorial());
        slf4jLogger.info("Factors of " + inputNumber + ": " + factorsThread.getFactors());

        slf4jLogger.info("Main thread finished last.");
    }
}

