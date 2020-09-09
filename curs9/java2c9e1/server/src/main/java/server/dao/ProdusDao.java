package server.dao;

import server.model.Produs;

import java.util.Collection;

public interface ProdusDao {
    void persist(Produs produs);

    Collection<Produs> findAll();

    Produs getById(int id);
}
