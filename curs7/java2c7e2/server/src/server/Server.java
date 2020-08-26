package server;

public class Server {

    public static void main(String[] args) {
        Chat chat = Chat.getInstance();

        ConnectionListener.getInstance().start(chat);
    }
}
