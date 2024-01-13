package org.example.ques1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MessageReceiver implements Runnable {
    private MessageQueue messageQueue;
    private String receiverName;
    private static final Logger logger= LoggerFactory.getLogger(MessageReceiver.class);

    /**
     *
     * @param messageQueue
     * @param receiverName
     */
    public MessageReceiver(MessageQueue messageQueue, String receiverName) {
        this.messageQueue = messageQueue;
        this.receiverName = receiverName;
    }

    public void run() {
        for(int i=0;i<3;i++) {
            try {
                String message = messageQueue.getMessage();
                logger.info("{} received {} ",receiverName,message);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
