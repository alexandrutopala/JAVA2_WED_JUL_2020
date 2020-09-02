package lib.dto;

import java.io.Serializable;
import java.time.Instant;

public abstract class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String user;

    private final Instant instant;

    public Event(String user) {
        this.user = user;
        instant = Instant.now();
    }

    public String getUser() {
        return user;
    }

    public Instant getInstant() {
        return instant;
    }

    @Override
    public String toString() {
        return "Event{" +
                "user='" + user + '\'' +
                ", instant=" + instant +
                '}';
    }
}
