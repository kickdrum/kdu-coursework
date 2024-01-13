package org.example.ques1;

public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        MessageSender messageSender=new MessageSender(messageQueue, "Sender " );
        Thread senderThread = new Thread(messageSender);
        MessageReceiver messageReceiver=new MessageReceiver(messageQueue, "Receiver " );
        Thread receiverThread = new Thread(messageReceiver);

        senderThread.start();
        receiverThread.start();
    }
}

