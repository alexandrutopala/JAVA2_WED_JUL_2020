package main;

import db.Adresa;
import db.Organizatie;

import javax.persistence.Persistence;
import java.util.Map;

public class Exemplu4 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        var organizatie = new Organizatie();

        var adresa1 = new Adresa();
        var adresa2 = new Adresa();

        adresa1.setStrada("Bd. Timisoara");
        adresa1.setOrganizatie(organizatie);

        adresa2.setStrada("Bc. Iuliu Maniu");
        adresa2.setOrganizatie(organizatie);

        organizatie.setAdrese(Map.of(
                "123456", adresa1,
                "654321", adresa2
        ));

        em.getTransaction().begin();

        em.persist(organizatie);
        em.persist(adresa1);
        em.persist(adresa2);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
