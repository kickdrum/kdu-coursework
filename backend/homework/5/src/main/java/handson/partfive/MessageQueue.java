package handson.partfive;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void addMessage(String message) throws InterruptedException {
        queue.put(message);
    }

    public String getMessage() throws InterruptedException {
        return queue.take();
    }
}
