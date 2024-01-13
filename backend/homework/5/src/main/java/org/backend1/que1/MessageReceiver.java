package org.backend1.que1;

import java.util.logging.Logger;

class MessageReceiver implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(MessageReceiver.class.getName());

    private MessageQueue messageQueue;

    public MessageReceiver(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    public void receiveMessage() {
        String msg = messageQueue.getMessage();
        LOGGER.info(Thread.currentThread().getName() + " received message: " + msg);
    }
    @Override
    public void run() {
        while (true) {
            receiveMessage();
            try {
                Thread.sleep(1000); // Add some delay between receiving messages
            } catch (InterruptedException e) {
                LOGGER.info("Thread Found");
            }
        }
    }
}