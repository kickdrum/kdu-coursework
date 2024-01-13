package org.example.q3;



public class Factorial implements Runnable{
    private int value;
    Object lock;
    Factorial(int value,Object lock)
    {
        this.value=value;
        this.lock=lock;
    }
    @Override
    public synchronized  void run() {
           FactorialAndFactors factorialCalc=new FactorialAndFactors(value,lock);
           factorialCalc.factorial();
    }
}
