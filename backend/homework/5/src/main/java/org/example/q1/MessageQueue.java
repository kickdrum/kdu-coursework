package org.example.q1;


import java.util.ArrayList;
import java.util.List;


public class MessageQueue {
    private List<String> messages = new ArrayList<>();
    int index=0;
    public synchronized void sendMessage(String message) {
        messages.add(message);
        if(index<messages.size())
            notifyAll();
    }

    public synchronized String receiveMessage() throws InterruptedException {
        while (index>=messages.size()||messages.isEmpty()) {
            wait();
        }
        String curMessage=messages.get(index);
        ++index;
        return curMessage;

    }

}
