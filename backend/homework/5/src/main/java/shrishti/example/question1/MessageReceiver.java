package shrishti.example.question1;
import shrishti.example.Logger.logger;

public class MessageReceiver implements Runnable{
    private final MessageQueue messageRecQueue;
    MessageReceiver(MessageQueue messageRecQueue){
        this.messageRecQueue=messageRecQueue;
    }
    @Override
    public void run(){
        while(true){
            while(messageRecQueue.messageQueueMain.size()==0){
                try{
                    Thread.sleep(3000);
                }
                catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
            logger.printOutput(messageRecQueue.getMessage());
        }
    }
}


