package org.example.ques2;

import org.example.ques1.MessageQueue;
import org.example.ques1.MessageReceiver;
import org.example.ques1.MessageSender;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();

        ExecutorService senderThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService receiverThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            senderThreadPool.submit(new MessageSender(messageQueue));
            receiverThreadPool.submit(new MessageReceiver(messageQueue));
        }

        senderThreadPool.shutdown();
        receiverThreadPool.shutdown();
    }
}
