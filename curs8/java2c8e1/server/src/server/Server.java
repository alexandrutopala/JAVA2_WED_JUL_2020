package server;

import server.service.MyServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) throws RemoteException {

        // Cream un registru cu rol de DNS care va rula pe portul 4545
        Registry registry = LocateRegistry.createRegistry(4545);

        // Expunem instanta de MyServiceImpl sub cheia de "myService"
        registry.rebind("myService", new MyServiceImpl());
    }
}
