package org.example;

class Factorial implements Runnable
{
    Thread thread;
    int number;

    Factorial(int number)
    {
        this.number = number;
        thread =new Thread(this,"Factorial Thread");
        Logging.print("\nFactorial thread created : "+ thread);
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
            Logging.print("Factorial is : ".concat(String.valueOf(f)));
        }
        catch (Exception e)
        {
            Logging.print(String.valueOf(e));
        }
        Logging.print("\nExiting "+ thread);
    }
}