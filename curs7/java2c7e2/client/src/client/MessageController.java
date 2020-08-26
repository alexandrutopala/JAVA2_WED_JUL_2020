package client;

import lib.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MessageController {

    private Socket server;

    private ObjectInputStream in;

    private ObjectOutputStream out;

    private MessageController() {
        try {
            server = new Socket("localhost", 4545);

            out = new ObjectOutputStream(server.getOutputStream());
            in = new ObjectInputStream(server.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static final class SingletonHolder {
        public static final MessageController INSTANCE = new MessageController();
    }

    public static MessageController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Message getNewMessage() throws IOException, ClassNotFoundException {
        return (Message) in.readObject();
    }

    public void sendMessage(Message message) throws IOException {
        out.writeObject(message);
        out.flush();
    }
}
