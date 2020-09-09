package server.service;

import lib.dto.ComandaDto;
import lib.service.ComandaService;
import server.convert.ComandaConvertor;
import server.dao.ComandaDao;
import server.dao.ProdusDao;
import server.dao.impl.ComandaDaoImpl;
import server.dao.impl.ProdusDaoImpl;

import javax.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.stream.Collectors;

public class ComandaServiceImpl extends UnicastRemoteObject
    implements ComandaService {

    private final ComandaDao comandaDao;

    private final ProdusDao produsDao;

    public ComandaServiceImpl() throws RemoteException {
        var emf = Persistence.createEntityManagerFactory("java2c9PU");
        var em = emf.createEntityManager();

        comandaDao = new ComandaDaoImpl(em);
        produsDao = new ProdusDaoImpl(emf.createEntityManager());
    }

    @Override
    public void persist(ComandaDto comandaDto) throws RemoteException {
        var comanda = ComandaConvertor.convert(comandaDto);

        var produse = comandaDto.getIdProduse().stream()
                .map(produsDao::getById)
                .collect(Collectors.toSet());

        comanda.setProduse(produse);

        comandaDao.persist(comanda);
    }

    @Override
    public Collection<ComandaDto> findByProdusId(int produsId) throws RemoteException {
        return comandaDao.findByProdusId(produsId).stream()
                .map(ComandaConvertor::convert)
                .collect(Collectors.toList());
    }
}
