package shrishti.example.question3;
import shrishti.example.Logger.logger;

public class Factorial implements Runnable{
    private final int number;
    public Factorial(int number){
        this.number=number;
    }
    private void calFactorial(){
        long factorial=1;
        int i=1;
        while(i!=number){
            factorial*=i;
            i++;
        }
        logger.printOutput("factorial of "+ number + "is" + factorial);
    }

    @Override
    public void run(){
        calFactorial();
    }
}
