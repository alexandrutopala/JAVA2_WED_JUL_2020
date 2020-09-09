package server.dao.impl;

import server.model.Comanda;

import javax.persistence.EntityManager;
import java.util.Collection;

public class ComandaDaoImpl implements server.dao.ComandaDao {

    private final EntityManager entityManager;

    public ComandaDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(Comanda comanda) {
        entityManager.getTransaction().begin();

        entityManager.persist(comanda);

        entityManager.getTransaction().commit();
    }

    @Override
    public Collection<Comanda> findByProdusId(int produsId) {
        var query = entityManager
                .createQuery("SELECT c FROM Comanda c JOIN c.produse p WHERE p.id = :id", Comanda.class);

        query.setParameter("id", produsId);

        return query.getResultList();
    }
}
