package org.backend1.que1;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Logger;

class MessageQueue {

    private final Queue<String> queue = new ArrayBlockingQueue<>(10);
    private static final Logger LOGGER = Logger.getLogger(MessageQueue.class.getName());

    public synchronized void addMessage(String msg) {
        if (queue.size() < 10) {
            queue.add(msg);
            notifyAll();
        }
    }

    public synchronized String getMessage() {
        while (queue.isEmpty()) {
            try {
                wait(); // Wait if the queue is empty
            } catch (InterruptedException e) {
                LOGGER.info("Thread issues");
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        MessageSender messageSender = new MessageSender(messageQueue);
        MessageReceiver messageReceiver = new MessageReceiver(messageQueue);

        for (int i = 0; i < 3; i++) {
            Thread senderThread = new Thread(messageSender, "Sender-" + i);
            senderThread.start();
        }

        for (int i = 0; i < 3; i++) {
            Thread receiverThread = new Thread(messageReceiver, "Receiver-" + i);
            receiverThread.start();
        }
    }
}