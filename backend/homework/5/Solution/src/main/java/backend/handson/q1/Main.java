package backend.handson.q1;

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        Thread[] senders = new Thread[3];
        for (int i=0 ; i < 2 ; i++){
            senders[i] =  new Thread(new MessageSender(messageQueue));
            String formattedName = String.format("Sender->%d",i);
            senders[i].setName(formattedName);
            senders[i].start();
        }

        Thread[] recievers = new Thread[3];
        for(int i=0; i < 3 ; i++){
            recievers[i] = new Thread(new MessageReciever(messageQueue));
            String formattedName = String.format("Receiver->%d",i);
            recievers[i].setName(formattedName);
            recievers[i].start();
        }
        senders[2] =  new Thread(new MessageSender(messageQueue),"Sender->2");
        senders[2].start();

    }
}
