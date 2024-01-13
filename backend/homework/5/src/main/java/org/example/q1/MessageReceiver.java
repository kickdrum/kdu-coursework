package org.example.q1;

import log.Log;

public class MessageReceiver implements Runnable{
    private MessageQueue messageQueue ;

    public MessageReceiver(MessageQueue messageQueue) {

        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
            String message="";
        try {
            message = messageQueue.receiveMessage();
        } catch (InterruptedException e) {
            // Rethrow a dedicated exception
            throw new MessageQueueInterruptedException("Error receiving message from the queue", e);
        }
        Log.info("Receiver " + Thread.currentThread().getId() + " received: " + message);
        }
    }

