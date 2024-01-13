package ques2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        ExecutorService senderThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService receiverThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 3; i++) {
            MessageSender sender = new MessageSender(messageQueue, "Sender " + i);
            senderThreadPool.submit(sender);
        }
        for (int i = 1; i <= 3; i++) {
            MessageReceiver receiver = new MessageReceiver(messageQueue, "Receiver " + i,3);
            receiverThreadPool.submit(receiver);
        }
    }
}

