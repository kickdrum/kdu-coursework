package org.backend1.que3;
import java.util.logging.Logger;

public class Factorial extends Thread{

    private static final Logger LOGGER = Logger.getLogger(Factorial.class.getName());


    private long factorl;
    private int num;

    Factorial(int num){
        this.num = num;
    }

    public long getfactorial(){
        return factorl;
    }

    @Override
    public void run(){
        factorl = calculatefac();
        LOGGER.info("factors are: " +  factorl);
    }

    public long calculatefac()
    {
        long res = 1;
        int i = 1;
        while(i <= this.num){
            res *= i;
            i++;
        }

        return res;
    }


}
