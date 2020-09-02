package lib.dto;

public class StatusEvent extends Event {

    public enum Status {
        CONNECTED, DISCONNECTED
    }

    private final Status status;

    public StatusEvent(String user, Status status) {
        super(user);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
