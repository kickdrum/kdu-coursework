package org.example.ques1;

import org.example.Log;

public class MessageSender implements Runnable {
    private MessageQueue messageQueue;

    public MessageSender(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    private void sendMessage() {
        String msg = "Message sent by " + Thread.currentThread().getName();
        messageQueue.getQueue().add(msg);

        Log.logger.info(msg);

    }

    @Override
    public void run() {
        sendMessage();
    }

}
