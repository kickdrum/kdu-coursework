package ques3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger= LoggerFactory.getLogger(Main.class);

    /**
     * creating two threads and calling start function on the objects
     * @param args
     */
    public static void main(String[] args) {
        int inputNumber = 6;
        Factorial factorialThread = new Factorial(inputNumber);
        Factors factorsThread = new Factors(inputNumber);
        factorialThread.start();
        factorsThread.start();
        try {
            factorialThread.join();
            factorsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Main thread finished.");
    }
}
