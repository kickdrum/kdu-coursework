package org.example.q3;

public class Factors implements Runnable{
    private int val;
    Object lock;
    Factors(int val,Object lock)
    {
        this.lock=lock;
        this.val=val;
    }
    @Override
    public synchronized void run() {
        FactorialAndFactors factorsCalc=new FactorialAndFactors(val,lock);
        factorsCalc.factors();
    }
}
