package handson.partfive;

public class MessageSender implements Runnable{
    private  MessageQueue messageQueue;

    public MessageSender(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }


    @Override
    public void run() {
        // Produce messages and add them to the MessageQueue
        try {
            for (int counter = 0; counter < 5; counter++) {
                String message = "Message from Sender " + Thread.currentThread().getId() + ": " + counter;
                messageQueue.addMessage(message);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}