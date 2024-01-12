package org.example.ques3;

import org.example.Log;

import java.util.ArrayList;

public class FactorThread implements Runnable{
    int factor;
    ArrayList<Integer> factors = new ArrayList<>();
    public FactorThread(int factor) {
        this.factor = factor;
    }
    public int getFactor() {
        return factor;
    }
    @Override
    public void run() {
        Log.logger.info("Factors of {} are:", factor);
        for(int i = 1; i <= factor; i++) {
            if(factor % i == 0) {
                factors.add(i);
            }
        }
        Log.logger.info("{} ", factors);
    }
}
