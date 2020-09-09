package lib.service;

import lib.dto.ComandaDto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface ComandaService extends Remote {

    void persist(ComandaDto comandaDto) throws RemoteException;

    Collection<ComandaDto> findByProdusId(int produsId) throws RemoteException;
}
