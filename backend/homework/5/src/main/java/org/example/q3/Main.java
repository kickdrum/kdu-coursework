package org.example.q3;
public class Main {
    public static void main(String []args) {
        Object lock=new Object();
        Thread t1 = new Thread(new Factors(50,lock));
        Thread t2=new Thread(new Factorial(5,lock));
        t1.start();
        t2.start();
    }

}
