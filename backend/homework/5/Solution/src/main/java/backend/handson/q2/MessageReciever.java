package backend.handson.q2;

import backend.handson.LogBack;

public class MessageReciever implements Runnable{

    private MessageQueue queue;
    MessageReciever(MessageQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String message = queue.getMessages();
            LogBack.outputLogger(message,"INFO");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
