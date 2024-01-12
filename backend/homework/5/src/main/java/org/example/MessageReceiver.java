package org.example;
import static org.example.Main.slf4jLogger;

public class MessageReceiver implements Runnable{
    private String id;
    private String name;
    private String message;

    private MessageQueue Q;
    MessageReceiver(String id, String name, MessageQueue Q){
        this.id=id;
        this.name=name;
//        this.message=message;
        this.Q=Q;
    }

    @Override
    public void run() {
        while (true) {
            while(Q.msgQueue.size()==0) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            slf4jLogger.info(Q.getMessage());

            }

        }
    }

