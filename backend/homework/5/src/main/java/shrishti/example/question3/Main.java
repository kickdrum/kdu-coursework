package shrishti.example.question3;

public class Main {
    public static void main(String[] args){
        int input= 10;
        Factorial factorial = new Factorial(input);
        Factors factors = new Factors(input);
        Thread factorialThread = new Thread(factorial);
        factorialThread.start();
        Thread factorThread = new Thread(factors);
        factorThread.start();

        try{
            factorThread.join();
            factorialThread.join();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }
}
