package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionListener {

    private ServerSocket serverSocket;

    private ConnectionListener() {
        try {
            serverSocket = new ServerSocket(4545);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static final class SingletonHolder {
        public static final ConnectionListener INSTANCE = new ConnectionListener();
    }

    public static ConnectionListener getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void start(Chat chat) {
        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();

                    User user = new User(socket, chat);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
