package lib.service;

import lib.dto.ProdusDto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface ProdusService extends Remote {

    void persist(ProdusDto produsDto) throws RemoteException;

    Collection<ProdusDto> findAll() throws RemoteException;
}
