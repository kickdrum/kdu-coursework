package questiontwo;

import handson.partfive.MessageQueue;
import handson.partfive.MessageReceiver;
import handson.partfive.MessageSender;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();


        ExecutorService senderThreadPool = Executors.newFixedThreadPool(3);


        ExecutorService receiverThreadPool = Executors.newFixedThreadPool(3);


        for (int counter = 0; counter < 3; counter++) {
            senderThreadPool.submit(new MessageSender(messageQueue));
        }

        for (int counter = 0; counter < 3; counter++) {
            receiverThreadPool.submit(new MessageReceiver(messageQueue));
        }


        senderThreadPool.shutdown();
        receiverThreadPool.shutdown();
    }
}
