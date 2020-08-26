package lib;

import java.io.Serializable;
import java.time.Instant;

public class Message implements Serializable {
     private static final Long serialVersionUID = 1L;

     private final String content;

     private final Instant timestamp;

     private final String sender;

    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
        timestamp = Instant.now();
    }

    public String getContent() {
        return content;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + sender + ": " + content;
    }
}
