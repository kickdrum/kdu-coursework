package backend.handson.q2;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MessageSender implements Runnable {

    private MessageQueue queue;
    MessageSender(MessageQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);

            String formattedMessage =  String.format(" %s Sent by: %d",scanner.nextLine(), ThreadLocalRandom.current().nextInt(1000));
            queue.addMessages(formattedMessage);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
