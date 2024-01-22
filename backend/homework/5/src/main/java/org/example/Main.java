package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main{
    static final Logger slf4jLogger = LoggerFactory.getLogger(question2.Main.class);

    public static void main(String[] args) {

        MessageQueue queue = new MessageQueue();
        MessageSender sender1=new MessageSender("id01","Prashant","First message: Hey",queue);
        Thread msg1=new Thread(sender1);
        MessageSender sender2=new MessageSender("id02","Mathangi","First message: Hello",queue);
        Thread msg2=new Thread(sender2);
        MessageSender sender3=new MessageSender("id03","Priyank","First message: Hey",queue);
        Thread msg3=new Thread(sender3);

        MessageReceiver receiver1=new MessageReceiver("id04","Chaitanya",queue);
        Thread onScreen1= new Thread(receiver1);
        MessageReceiver receiver2=new MessageReceiver("id05", "Kshitiz",queue);
        Thread onScreen2= new Thread(receiver2);
        MessageReceiver receiver3=new MessageReceiver("id06", "Kavisha",queue);
        Thread onScreen3= new Thread(receiver3);

        msg1.start();
        msg2.start();
        msg3.start();

        onScreen1.start();
        onScreen2.start();
        onScreen3.start();


    }
}