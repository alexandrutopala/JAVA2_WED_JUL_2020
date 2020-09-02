package client.controller;

import lib.api.MessageService;
import lib.dto.Event;
import lib.dto.MessageEvent;
import lib.dto.StatusEvent;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;

public class MessageController {

    private final MessageService messageService;

    private MessageController() {
        try {
            var registry = LocateRegistry.getRegistry("localhost", 4545);

            messageService = (MessageService) registry.lookup("messageService");
        } catch (RemoteException | NotBoundException e) {
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

    public void sendMessage(MessageEvent message) {
        try {
            messageService.sendMessage(message);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void changeStatus(StatusEvent statusEvent) {
        try {
            messageService.changeStatus(statusEvent);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Event> getEvents(String user) {
        try {
            return messageService.getEvents(user);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
