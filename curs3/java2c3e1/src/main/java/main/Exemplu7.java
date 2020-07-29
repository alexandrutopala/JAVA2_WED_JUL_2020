package main;

import db.Tricou;

import javax.persistence.Persistence;

public class Exemplu7 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c3PU");
        var em = emf.createEntityManager();

        var t = em.find(Tricou.class, 2);

        // Sterge instanta t din contextul de persistenta,
        // dar nu si din baza de date
        em.detach(t);

        // face detach tuturor entitatilor administrate
        em.clear();
    }
}
