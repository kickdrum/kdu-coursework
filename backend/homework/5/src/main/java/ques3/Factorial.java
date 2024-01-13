package ques3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
class Factorial extends Thread {
    private int number;
    private long factorial;
    private static final Logger logger= LoggerFactory.getLogger(Main.class);

    /**
     *
     * @param number
     */
    public Factorial(int number) {
        this.number = number;
        this.factorial = 1;
    }

    /**
     * to call calculateFactorial method
     */
    public void run() {
        calculateFactorial();
    }

    private void calculateFactorial() {
        for (int i = 1; i <= number; i++)
            factorial *= i;
        logger.info("Factorial of " + number + ": " + factorial);
    }
}


