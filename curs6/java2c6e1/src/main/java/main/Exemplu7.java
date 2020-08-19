package main;

import db.Departament;

import javax.persistence.Persistence;

public class Exemplu7 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        var query = em.createQuery("SELECT d FROM Departament d JOIN FETCH d.programatori p WHERE d.id = :id", Departament.class);

        query.setParameter("id", 0);

        var d = query.getSingleResult();

        System.out.println(d.getProgramatori().size());
    }
}
