package server.service;

import lib.api.MessageService;
import lib.dto.Event;
import lib.dto.MessageEvent;
import lib.dto.StatusEvent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {

    private final Map<String, Queue<Event>> events = new ConcurrentHashMap<>();

    public MessageServiceImpl() throws RemoteException {
    }

    @Override
    public void sendMessage(MessageEvent message) throws RemoteException {
        events.forEach((user, queue) -> queue.add(message));
    }

    @Override
    public void changeStatus(StatusEvent statusEvent) throws RemoteException {
        var user = statusEvent.getUser();

        events.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(user))
                .forEach(entry -> entry.getValue().add(statusEvent));

        if (statusEvent.getStatus() == StatusEvent.Status.CONNECTED) {
            events.putIfAbsent(user, new LinkedBlockingQueue<>());
        }
    }

    @Override
    public List<Event> getEvents(String user) throws RemoteException {
        var queue = events.get(user);

        events.put(user, new LinkedBlockingQueue<>());

        return new ArrayList<>(queue);
    }
}
