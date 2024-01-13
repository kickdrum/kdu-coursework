package org.example.q1;

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();

        Thread sender1 = new Thread(new MessageSender(messageQueue, "Sender1"));
        Thread sender2 = new Thread(new MessageSender(messageQueue, "Sender2"));
        Thread sender3 = new Thread(new MessageSender(messageQueue, "Sender3"));
        sender1.start();
        sender2.start();
        sender3.start();

        // Creating and starting receiver threads
        Thread receiver1 = new Thread(new MessageReceiver(messageQueue));
        Thread receiver2 = new Thread(new MessageReceiver(messageQueue));
        Thread receiver3 = new Thread(new MessageReceiver(messageQueue));
        receiver1.start();
        receiver2.start();
        receiver3.start();

    }
}
