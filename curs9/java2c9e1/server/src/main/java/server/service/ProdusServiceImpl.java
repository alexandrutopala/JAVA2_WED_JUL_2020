package server.service;

import lib.dto.ProdusDto;
import lib.service.ProdusService;
import server.convert.ProdusConvertor;
import server.dao.ProdusDao;
import server.dao.impl.ProdusDaoImpl;

import javax.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.stream.Collectors;

public class ProdusServiceImpl extends UnicastRemoteObject
        implements ProdusService {

    private final ProdusDao produsDao;

    public ProdusServiceImpl() throws RemoteException {
        var emf = Persistence.createEntityManagerFactory("java2c9PU");
        var em = emf.createEntityManager();

        produsDao = new ProdusDaoImpl(em);
    }

    @Override
    public void persist(ProdusDto produsDto) throws RemoteException {
        var produs = ProdusConvertor.convert(produsDto);

        produsDao.persist(produs);
    }

    @Override
    public Collection<ProdusDto> findAll() throws RemoteException {
        return produsDao.findAll().stream()
                .map(ProdusConvertor::convert)
                .collect(Collectors.toList());
    }
}
