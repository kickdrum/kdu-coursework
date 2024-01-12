package backend.handson.q1;

import backend.handson.LogBack;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
    private Queue<String> messages = new LinkedList<>();

    /**
     * Adds a message to the message queue in a thread-safe manner and notifies waiting threads.
     *
     * @param message The message to be added.
     */
    public synchronized void addMessages(String message){
        messages.add(message);
        notifyAll();
    }

    /**
     * Retrieves a message from the message queue in a thread-safe manner, waiting if necessary.
     *
     * @return The retrieved message.
     * @throws InterruptedException If the thread is interrupted while waiting for a message.
     */
    public synchronized String getMessages() throws InterruptedException{
        while (messages.isEmpty()){
            LogBack.outputLogger("Waiting.. Enter your Message:","INFO");
            wait();
        }
        return messages.remove();
    }

}
