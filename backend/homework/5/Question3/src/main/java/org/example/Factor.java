package org.example;

class Factor implements Runnable
{
    Thread thread;
    int number;

    Factor(int number)
    {
        this.number = number;
        thread =new Thread(this,"Factor Thread");
        Logging.print("\nFactor thread created : "+ thread);
        thread.start();
    }

    public void run()
    {
        try
        {
            Logging.print("Factors of : ");
            for(int i = 1;i<=number;i++)
            {
                if(number%i == 0 )
                    Logging.print(String.valueOf(i).concat(" "));
            }
        }
        catch (Exception e)
        {
            Logging.print(String.valueOf(e));
        }
        Logging.print("\nExiting "+ thread);
    }
}
