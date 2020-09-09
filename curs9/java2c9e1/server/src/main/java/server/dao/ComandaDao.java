package server.dao;

import server.model.Comanda;

import java.util.Collection;

public interface ComandaDao {
    void persist(Comanda comanda);

    Collection<Comanda> findByProdusId(int produsId);
}
