package org.example;

public class MessageSender implements Runnable{
    private String id;
    private String name;
    private String message;
    private MessageQueue queue;
    MessageSender(String id, String name,String message, MessageQueue queue){
        this.id=id;
        this.name=name;
        this.message=message;
        this.queue=queue;
    }
    @Override
    public void run() {
        queue.addMessage(message);
    }


}
