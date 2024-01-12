package org.example;

public class MessageReceiver implements Runnable {
    private MessageQueue messageQueue;

    public MessageReceiver(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
            try {
                String message = messageQueue.dequeue();
                Logging.print("Received from receiver " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
