package main;

import db.Persoana;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu3 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c2PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Persoana p = em.find(Persoana.class, 1);

        System.out.println(p);

        p.setNume("Dorel");

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
