package org.example.ques1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
class MessageSender implements Runnable {
    private static final Logger logger= LoggerFactory.getLogger(Main.class);
    private MessageQueue messageQueue;
    private String senderName;

    /**
     *
     * @param messageQueue
     * @param senderName
     */
    public MessageSender(MessageQueue messageQueue, String senderName) {
        this.messageQueue = messageQueue;
        this.senderName = senderName;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            String message = senderName + " message " + i;
            messageQueue.addMessage(message);
            logger.info("{}.",senderName + " sent: " + message);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}