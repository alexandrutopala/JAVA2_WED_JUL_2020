package server;

import server.service.ComandaServiceImpl;
import server.service.ProdusServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) throws RemoteException {
        var registry = LocateRegistry.createRegistry(4545);

        registry.rebind("produsService", new ProdusServiceImpl());
        registry.rebind("comandaService", new ComandaServiceImpl());
    }
}
