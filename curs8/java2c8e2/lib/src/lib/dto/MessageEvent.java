package lib.dto;

public class MessageEvent extends Event {

    private final String message;

    public MessageEvent(String user, String message) {
        super(user);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
