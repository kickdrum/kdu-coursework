package org.example;
import java.util.*;

import static org.example.Main.slf4jLogger;

public class MessageQueue{
    public Queue<String> msgQueue=new LinkedList<>();

    public synchronized void addMessage(String msg) {
        msgQueue.add(msg);
        notifyAll();
    }

    public synchronized String getMessage() {
        try {
            while(msgQueue==null){
                wait();
            }
            return msgQueue.poll();
        } catch (NullPointerException e) {
            slf4jLogger.error("Error: MessageQueue is null.");
            return null;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
