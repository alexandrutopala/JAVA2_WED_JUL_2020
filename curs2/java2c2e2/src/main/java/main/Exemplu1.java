package main;

import db.Persoana;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c2PU");
        EntityManager em = emf.createEntityManager();

        Persoana p = new Persoana();

        p.setNume("gigel");

        try {
            em.getTransaction().begin();

            em.persist(p);
            em.flush();

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
