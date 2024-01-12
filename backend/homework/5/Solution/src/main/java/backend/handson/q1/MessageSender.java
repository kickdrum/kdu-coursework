package backend.handson.q1;


import java.util.Scanner;

public class MessageSender implements Runnable{

    private MessageQueue queue;


    MessageSender(MessageQueue queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        Scanner scanner = new Scanner(System.in);
        String formattedMessage =  String.format("%s Sent by: %s",scanner.nextLine(),Thread.currentThread().getName());
        queue.addMessages(formattedMessage);
    }
}
