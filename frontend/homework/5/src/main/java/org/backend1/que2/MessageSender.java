package org.backend1.que2;

import org.backend1.que3.Main;

import java.util.logging.Logger;

public class MessageSender implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(MessageSender.class.getName());


    private MessageQueue messageQueue;

    public MessageSender(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        sendMessage();
    }

    public void sendMessage() {
        String msg = "Message from " + Thread.currentThread().getName();
        LOGGER.info("{} received message: {}", Thread.currentThread().getName(), msg);
        messageQueue.addMessage(msg);
    }
}
