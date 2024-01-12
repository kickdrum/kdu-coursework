package org.example.ques1;


import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {
    LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();

    public LinkedBlockingQueue<String> getQueue() {
        return linkedBlockingQueue;
    }

}