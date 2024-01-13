package shrishti.example.question3;
import shrishti.example.Logger.logger;
public class Factors implements Runnable{
    private final int number;
    public Factors(int number){
        this.number=number;
    }
    private void calculateFactors(){
        logger.printOutput("Factors of number"+number+"is:");
        int i=1;
        while(i!=number){
            if(number%i==0){
                System.out.println(i+"  ");
            }
            i++;
        }
    }
    @Override
    public void run(){
        calculateFactors();
    }


}