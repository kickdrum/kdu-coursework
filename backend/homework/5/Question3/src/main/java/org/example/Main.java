package org.example;

public  class Main
{
    public static void main(String []args)
    {
        Factor factor = new Factor(6);
        Factorial factorial = new Factorial(6);

        try
        {
            factorial.thread.join();
            factor.thread.join();
        }
        catch (InterruptedException e)
        {
            Logging.print(String.valueOf(e));
        }

        Logging.print("Exiting main thread");
    }
}