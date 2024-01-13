package shrishti.example.question1;
import java.util.*;
import shrishti.example.Logger.logger;
public class MessageQueue{
   public Queue<String> messageQueueMain = new LinkedList<>();

   public synchronized void addMessage(String msg){
       messageQueueMain.add(msg);
       notifyAll();
   }

    public synchronized  String getMessage(){
       try{
           while(messageQueueMain==null){
               wait();
           }
           return messageQueueMain.poll();
       }
       catch(NullPointerException e){
         logger.printMessage("Message Queue is null");
           return null;
       }
       catch(InterruptedException e){
           throw new RuntimeException(e);
       }
    }


}

