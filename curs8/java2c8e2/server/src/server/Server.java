package server;

import server.service.MessageServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) throws RemoteException {
        var registry = LocateRegistry.createRegistry(4545);

        registry.rebind("messageService", new MessageServiceImpl());
    }
}
