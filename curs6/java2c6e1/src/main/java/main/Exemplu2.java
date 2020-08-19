package main;

import db.Inginer;
import db.Programator;

import javax.persistence.Persistence;

public class Exemplu2 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        var programator = new Programator();

        programator.setNume("gigel");
        programator.setLimbaj("java");

        var inginer = new Inginer();

        inginer.setNume("dorel");
        inginer.setSpecializare("electrice");

        em.getTransaction().begin();

        em.persist(programator);
        em.persist(inginer);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
