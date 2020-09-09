package server.dao.impl;

import server.model.Produs;

import javax.persistence.EntityManager;
import java.util.Collection;

public class ProdusDaoImpl implements server.dao.ProdusDao {

    private final EntityManager entityManager;

    public ProdusDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(Produs produs) {
        entityManager.getTransaction().begin();

        entityManager.persist(produs);

        entityManager.getTransaction().commit();
    }

    @Override
    public Collection<Produs> findAll() {
        var query = entityManager.createQuery("SELECT p FROM Produs p", Produs.class);

        return query.getResultList();
    }

    @Override
    public Produs getById(int id) {
        return entityManager.find(Produs.class, id);
    }
}
