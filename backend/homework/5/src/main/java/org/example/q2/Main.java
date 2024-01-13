package org.example.q2;
import org.example.q1.MessageQueue;
import org.example.q1.MessageReceiver;
import org.example.q1.MessageSender;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String []args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        MessageQueue messageQueue=new MessageQueue();
        executorService.submit(new MessageSender(messageQueue,"Message from Producer1"));
        executorService.submit(new MessageSender(messageQueue,"Message from Producer2"));
        executorService.submit(new MessageSender(messageQueue,"Message from Producer3"));

        executorService.submit(new MessageReceiver(messageQueue));
        executorService.submit(new MessageReceiver(messageQueue));
        executorService.submit(new MessageReceiver(messageQueue));

        executorService.shutdown();
    }
}
