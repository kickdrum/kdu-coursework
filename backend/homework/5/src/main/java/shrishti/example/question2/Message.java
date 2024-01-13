package shrishti.example.question2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Message {
    public static  void main(String[] args){
        ExecutorService executorService=Executors.newFixedThreadPool(3);

        MessageQueue queue = new MessageQueue();
        MessageSender senderA = new MessageSender("hello mssg 1", queue);
        executorService.submit(senderA);
        MessageSender senderB = new MessageSender("hello mssg 2",queue);
        executorService.submit(senderB);
        MessageSender senderC = new MessageSender("hello mssg 3",queue);
        executorService.submit(senderC);

        MessageReceiver receiverA = new MessageReceiver(queue);
        executorService.submit(receiverA);
        MessageReceiver receiverB = new MessageReceiver(queue);
        executorService.submit(receiverB);
        MessageReceiver receiverC = new MessageReceiver(queue);
        executorService.submit(receiverC);
    }

}
