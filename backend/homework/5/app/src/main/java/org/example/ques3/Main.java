package org.example.ques3;

import org.example.Log;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Log.logger.info("Enter the number to find all of its factors");
        int factorNum = scanner.nextInt();

        Log.logger.info("Enter the number to calculate its factorial");
        int factorialNum = scanner.nextInt();

        FactorialThread factorial = new FactorialThread(factorialNum);
        Thread factorialThread = new Thread(factorial);

        FactorThread factor = new FactorThread(factorNum);
        Thread factorThread = new Thread(factor);

        factorThread.start();
        factorialThread.start();

        try {
            factorThread.join();
            factorialThread.join();
        }
        catch(InterruptedException e){
            Log.logger.error("Thread interrupted");
        }

        Log.logger.info("Main thread is ending");

    }
}
