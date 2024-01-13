package org.example.q3;

import log.Log;

public class FactorialAndFactors {
    private int num;
    Object lock;
    FactorialAndFactors(int num,Object lock)
    {
        this.num=num;
        this.lock=lock;
    }

    public void factorial()
    {

        synchronized (lock) {
            long fact = 1;
            for (int i = num; i >= 1; i--) {
                fact *= i;
            }
            Log.info("Factorial " + fact);
        }
    }
    public void factors()
    {
        synchronized (lock) {
            Log.info("Factor are");
            for (int i = 2; i <= num; i++) {
                if (num % i == 0)
                    Log.info("" + i);
            }
        }
    }
}
