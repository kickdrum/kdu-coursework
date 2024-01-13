package handson.partfive;

public class MessageReceiver extends Thread{
    private final MessageQueue messageQueue;

    public MessageReceiver(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        // Print messages from the MessageQueue
        try {
            while (true) {
                String message = messageQueue.getMessage();
                ProcessingLogs processingLogs = new ProcessingLogs();
                processingLogs.displayLogs("Received message in Receiver " + Thread.currentThread().getId() + ": " + message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

