package handson.partfive;

public class Main {
    public static void main(String[] args){
        MessageQueue messageQueue = new MessageQueue();

        // Creating MessageSender and MessageReceiver threads
        for (int i = 0; i < 3; i++) {
            new Thread(new MessageSender(messageQueue)).start();
            new Thread(new MessageReceiver(messageQueue)).start();
        }

    }
}
