package server;

import lib.Message;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class Chat {

    private Collection<User> users = new CopyOnWriteArraySet<>();

    private Chat() {
    }

    private static final class SingletonHolder {
        public static final Chat INSTANCE = new Chat();
    }

    public static Chat getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void newMessage(Message message) {
        users.forEach(user -> {
            try {
                user.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
