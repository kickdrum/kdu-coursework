package org.example;

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();

        for (int i = 0; i < 3; i++) {
            MessageSender sender = new MessageSender(messageQueue);
            new Thread(sender).start();
        }

        for (int i = 0; i < 3; i++) {
            MessageReceiver receiver = new MessageReceiver(messageQueue);
            new Thread(receiver).start();
        }
    }
}
