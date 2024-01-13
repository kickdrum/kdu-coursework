package org.backend1.que3;
import java.util.logging.Logger;

public class Factors extends Thread{

    private static final Logger LOGGER = Logger.getLogger(Factors.class.getName());


    private String factrs;
    private int number;

    public Factors(int number){
        this.number = number;
    }

    @Override
    public void run(){
        factrs = calculateFactors(number);
        LOGGER.info("factors are: " +  factrs);
    }

    public String calculateFactors(int n){
        StringBuilder res = new StringBuilder();
        for(int i = 2; i*i < n; i++){
            if(n % i == 0){
                res.append(i).append(" ");

                if(n / i != i) res.append(i).append(" ");
            }
        }
        return res.toString();
    }
}
