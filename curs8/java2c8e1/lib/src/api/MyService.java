package api;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Interfata API-ului trebuie sa extinda Remote
public interface MyService extends Remote {

    // Fiecare metoda definita trebuie sa declare aruncarea lui RemoteException
    String reverse(String s) throws RemoteException;
}
