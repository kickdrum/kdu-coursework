package org.example.q1;

public class MessageQueueInterruptedException extends RuntimeException{
    public MessageQueueInterruptedException(String message, InterruptedException cause) {
        super(message, cause);
    }
}
