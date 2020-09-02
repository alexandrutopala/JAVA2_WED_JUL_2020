package server.service;

import api.MyService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Mostenim UnicastRemoteObject pentru a putea expune in retea
// implementarea MyServiceImpl
public class MyServiceImpl extends UnicastRemoteObject implements MyService {

    public MyServiceImpl() throws RemoteException {
    }

    @Override
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
