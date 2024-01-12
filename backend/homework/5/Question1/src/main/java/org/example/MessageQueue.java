package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
    private Queue<String> queue = new LinkedList<>();

    public synchronized void enqueue(String message) {
        queue.add(message);
        notifyAll();
    }

    public synchronized String dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    }
}
