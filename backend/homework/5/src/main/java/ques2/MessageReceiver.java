package ques2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
class MessageReceiver implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);
    private MessageQueue messageQueue;
    private String receiverName;
    private int messagesToReceive;

    /**
     *
     * @param messageQueue
     * @param receiverName
     * @param messagesToReceive
     */
    public MessageReceiver(MessageQueue messageQueue, String receiverName, int messagesToReceive) {
        this.messageQueue = messageQueue;
        this.receiverName = receiverName;
        this.messagesToReceive = messagesToReceive;
    }

    public void run() {
        for (int i = 0; i < messagesToReceive; i++) {
            try {
                String message = messageQueue.getMessage();
                logger.debug("\n{} received: {}", receiverName, message);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}