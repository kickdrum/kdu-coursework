package shrishti.example.question2;

public class MessageSender implements Runnable {

    private String message;
    private MessageQueue messageQueue;

    MessageSender(String message, MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
        this.message = message;
    }

    @Override
    public void run() {
        messageQueue.addMessage(message);
    }
}

