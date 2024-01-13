package questionthree;

import handson.partfive.ProcessingLogs;

class Factor implements Runnable
{
    Thread thread;
    int number;
    ProcessingLogs processingLogs = new ProcessingLogs();
    Factor(int number)
    {
        this.number = number;
        thread =new Thread(this,"Factor Thread");
        processingLogs.displayLogs("\nFactor thread created : "+ thread);
        thread.start();
    }
    public void run()
    {
        try
        {
            processingLogs.displayLogs("Factors of : ");
            for(int i = 1;i<=number;i++)
            {
                if(number%i == 0 )
                    processingLogs.displayLogs(String.valueOf(i).concat(" "));
            }
        }
        catch (Exception e)
        {
            processingLogs.displayLogs(String.valueOf(e));
        }
        processingLogs.displayLogs("\nExiting "+ thread);
    }
}

class Factorial implements Runnable
{
    Thread thread;
    int number;
    ProcessingLogs processingLogs = new ProcessingLogs();
    Factorial(int number)
    {
        this.number = number;
        thread =new Thread(this,"Factorial Thread");
        processingLogs.displayLogs("\nFactorial thread created : "+ thread);
        thread.start();
    }
    public void run()
    {
        try
        {
            long f = 1;
            for(int i = 2; i<= number; i++)
            {
                f*=i;
            }
            processingLogs.displayLogs("Factorial is : ".concat(String.valueOf(f)));
        }
        catch (Exception e)
        {
            processingLogs.displayLogs(String.valueOf(e));
        }
        processingLogs.displayLogs("\nExiting "+ thread);
    }
}
public  class Main
{

    public static void main(String []args)
    {
        ProcessingLogs processingLogs = new ProcessingLogs();
        Factor factor = new Factor(6);
        Factorial factorial = new Factorial(6);
        try
        {
            factorial.thread.join();
            factor.thread.join();
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        processingLogs.displayLogs("Exiting main thread");
    }
}
