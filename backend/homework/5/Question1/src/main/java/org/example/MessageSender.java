package org.example;

public class MessageSender implements Runnable {
    private MessageQueue messageQueue;

    public MessageSender(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
            String message = "Message from sender ".concat(String.valueOf(Thread.currentThread().getId()));
            messageQueue.enqueue(message);
    }
}
