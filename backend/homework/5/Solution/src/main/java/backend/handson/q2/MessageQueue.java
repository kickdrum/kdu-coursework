package backend.handson.q2;

import backend.handson.LogBack;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {

    private BlockingQueue<String> messages = new LinkedBlockingQueue<>();

    /**
     * Adds a message to the message queue in a thread-safe manner and notifies waiting threads.
     *
     * @param message The message to be added.
     * @throws InterruptedException If the thread is interrupted while waiting for space in the queue.
     */
    public synchronized void addMessages(String message) throws InterruptedException{
        messages.put(message);
        notifyAll();
    }

    /**
     * Retrieves a message from the message queue in a thread-safe manner, waiting if necessary.
     *
     * @return The retrieved message.
     * @throws InterruptedException If the thread is interrupted while waiting for a message.
     */
    public synchronized String getMessages() throws InterruptedException{
        while(messages.isEmpty()){
            LogBack.outputLogger("Waiting.. Enter your Message:","INFO");
            wait();
        }
        return messages.take();
    }
}
