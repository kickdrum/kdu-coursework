package ques3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Factors extends Thread {
    private int number;
    private static final Logger logger= LoggerFactory.getLogger(Main.class);
    public Factors(int number) {
        this.number = number;
    }

    /**
     * to call calculateFactors method
     */
    public void run() {
        calculateFactors();
    }

    /**
     * to log the factors
     */
    private void calculateFactors() {
        logger.info("Factors of " + number + ": ");
        for (int i = 1; i <= number; i++)
            if (number % i == 0)
                logger.info("{}",i);
    }
}

