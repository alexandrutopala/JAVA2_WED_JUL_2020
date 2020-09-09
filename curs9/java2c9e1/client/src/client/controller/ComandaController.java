package client.controller;

import lib.dto.ComandaDto;
import lib.service.ComandaService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Collection;

public class ComandaController {

    private final ComandaService comandaService;

    private ComandaController() {
        try {
            var registry = LocateRegistry.getRegistry("localhost", 4545);

            comandaService = (ComandaService) registry.lookup("comandaService");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }

    private static final class SingletonHolder {
        public static final ComandaController INSTANCE = new ComandaController();
    }

    public static ComandaController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void persist(ComandaDto comandaDto) {
        try {
            comandaService.persist(comandaDto);
        } catch (RemoteException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }

    public Collection<ComandaDto> findByProdusId(int produsId) {
        try {
            return comandaService.findByProdusId(produsId);
        } catch (RemoteException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }
}
