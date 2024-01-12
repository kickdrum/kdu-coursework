package org.example.ques1;

import org.example.Log;

public class MessageReceiver implements Runnable {
    private MessageQueue messageQueue;

    public MessageReceiver(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    public synchronized boolean receiveMessage() {
        String message = messageQueue.getQueue().poll();
        if (message != null) {
            Log.logger.info("message \"{}\" received by {}", message, Thread.currentThread().getName());
            return true;
        }
        Log.logger.info("no message to read for " + Thread.currentThread().getName());
        return false;
    }

    @Override
    public void run() {
        while (true) {
            if (receiveMessage()) {
                return;
            }

        }
    }
}
