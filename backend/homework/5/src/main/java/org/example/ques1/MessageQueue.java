package org.example.ques1;
import java.util.*;
class MessageQueue {
    private Queue<String> messages = new LinkedList<>();

    /**
     *
     * @param message
     */
    public synchronized void addMessage(String message) {
        messages.add(message);
        notifyAll();
    }

    /**
     *
     * @return
     * @throws InterruptedException
     */
    public synchronized String getMessage() throws InterruptedException {
        while (messages.isEmpty())
            wait();
        return messages.poll();
    }
}

