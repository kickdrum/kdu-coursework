package shrishti.example.question1;

public class Message {
    public static  void main(String[] args){
        MessageQueue queue = new MessageQueue();
        MessageSender senderA = new MessageSender("hello mssg 1", queue);
        Thread messageA = new Thread(senderA);
        MessageSender senderB = new MessageSender("hello mssg 2",queue);
        Thread messageB = new Thread(senderB);
        MessageSender senderC = new MessageSender("hello mssg 3",queue);
        Thread messageC = new Thread(senderC);

        MessageReceiver receiverA = new MessageReceiver(queue);
        Thread messageRecievedA = new Thread(receiverA);
        MessageReceiver receiverB = new MessageReceiver(queue);
        Thread messageRecievedB = new Thread(receiverB);
        MessageReceiver receiverC = new MessageReceiver(queue);
        Thread messageRecievedC = new Thread(receiverC);
        messageA.start();
        messageB.start();
        messageC.start();
        messageRecievedA.start();
        messageRecievedB.start();
        messageRecievedC.start();


    }

}
