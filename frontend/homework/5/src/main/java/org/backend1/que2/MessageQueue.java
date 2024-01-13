package org.backend1.que2;

import java.util.concurrent.*;

public class MessageQueue {

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

    public void addMessage(String msg) {
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public String getMessage() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        ExecutorService senderThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService receiverThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            senderThreadPool.execute(new MessageSender(messageQueue));
            receiverThreadPool.execute(new MessageReceiver(messageQueue));
        }
        senderThreadPool.shutdown();
        receiverThreadPool.shutdown();
    }
}
