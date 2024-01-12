package org.example.ques1;

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();

        for (int i = 1; i <= 3; i++) {
            MessageSender messageSender = new MessageSender(messageQueue);
            MessageReceiver messageReceiver = new MessageReceiver(messageQueue);

            Thread sender = new Thread(messageSender);
            Thread receiver = new Thread(messageReceiver);

            sender.setName("sender thread " + i);
            receiver.setName("receiver thread " + i);

            sender.start();
            receiver.start();
        }
    }
}
