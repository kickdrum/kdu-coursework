package backend.handson.q1;

import backend.handson.LogBack;

public class MessageReciever implements Runnable{

    private MessageQueue queue;

    MessageReciever(MessageQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String recievedMessage = queue.getMessages();
            LogBack.outputLogger(recievedMessage,"INFO");
        } catch (InterruptedException e) {
            LogBack.outputLogger(e.getMessage(),"ERROR");
            Thread.currentThread().interrupt();
        }

    }
}
