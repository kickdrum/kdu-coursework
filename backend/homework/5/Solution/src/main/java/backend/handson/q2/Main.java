package backend.handson.q2;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Main {
    public static void main(String[] args){
        MessageQueue messageQueue = new MessageQueue();
       ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 2; i++) {
            executorService.execute(new MessageSender(messageQueue));
        }
        for (int i = 0; i < 3; i++) {
            executorService.execute(new MessageReciever(messageQueue));
        }
        executorService.execute(new MessageSender(messageQueue));
    }
}
