package org.example2;

import org.example.MessageQueue;
import org.example.MessageReceiver;
import org.example.MessageSender;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            MessageSender sender = new MessageSender(messageQueue);
            executorService.execute(sender);
        }

        for (int i = 0; i < 3; i++) {
            MessageReceiver receiver = new MessageReceiver(messageQueue);
            executorService.execute(receiver);
        }
        executorService.shutdown();
    }
}
