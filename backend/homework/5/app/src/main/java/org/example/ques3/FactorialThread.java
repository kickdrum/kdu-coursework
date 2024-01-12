package org.example.ques3;

import org.example.Log;

public class FactorialThread implements Runnable{
    int factorialNum;
    public FactorialThread(int factorial) {
        this.factorialNum = factorial;

    }
    public int getFactorial() {
        return factorialNum;
    }
    @Override
    public void run() {
        int factor = 1;
        for(int i = 1; i <= factorialNum; i++) {
            factor *= i;
        }
        Log.logger.info("Factorial of {} is {}", factorialNum, factor);
    }
}
