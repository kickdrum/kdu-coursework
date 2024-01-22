package question2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static final Logger slf4jLogger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        MessageQueue queue = new MessageQueue();
        MessageSender sender1=new MessageSender("id01","Prashant","First message: Hey",queue);
        executorService.submit(sender1);
        MessageSender sender2=new MessageSender("id02","Mathangi","First message: Hello",queue);
        executorService.submit(sender2);
        MessageSender sender3=new MessageSender("id03","Priyank","First message: Hey",queue);
        executorService.submit(sender3);

        MessageReceiver receiver1=new MessageReceiver("id04","Chaitanya",queue);
        executorService.submit(receiver1);
        MessageReceiver receiver2=new MessageReceiver("id05", "Kshitiz",queue);
        executorService.submit(receiver2);
        MessageReceiver receiver3=new MessageReceiver("id06", "Kavisha",queue);
        executorService.submit(receiver3);

    }
}
