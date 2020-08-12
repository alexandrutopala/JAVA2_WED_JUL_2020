package main;

import db.Adresa;
import db.Depozit;

import javax.persistence.Persistence;
import java.util.Map;

public class Exemplu7 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        var adresa = new Adresa();

        adresa.setStrada("Bd. 1 Mai");

        var depozit = new Depozit();

        depozit.setFirme(Map.of(
                adresa, "Gigel SRL"
        ));

        em.getTransaction().begin();

        em.persist(adresa);
        em.persist(depozit);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
