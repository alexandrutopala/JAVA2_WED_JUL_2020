package client;

import api.MyService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        // Obtinem registrul ce ruleaza pe masina locala la portul 4545
        Registry registry = LocateRegistry.getRegistry("localhost", 4545);

        // Obtinem din registru un stub asociat cheii "myService"
        MyService myService = (MyService) registry.lookup("myService");

        var res = myService.reverse("Hello!");

        System.out.println(res);
    }
}
