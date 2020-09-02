package lib.api;

import lib.dto.Event;
import lib.dto.MessageEvent;
import lib.dto.StatusEvent;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MessageService extends Remote {

    void sendMessage(MessageEvent message) throws RemoteException;

    void changeStatus(StatusEvent statusEvent) throws RemoteException;

    List<Event> getEvents(String user) throws RemoteException;
}
