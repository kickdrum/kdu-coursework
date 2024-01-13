package org.example.q1;

public class MessageSender implements Runnable{

    private MessageQueue messageQueue;
    private String name;

    public MessageSender(MessageQueue messageQueue,String name) {
        this.messageQueue = messageQueue;
        this.name=name;
    }

    @Override
    public void run() {

        messageQueue.sendMessage(name);

    }
}
