package main;

import db.Magazin;

import javax.persistence.Persistence;
import java.util.Map;

public class Exemplu1 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        var magazin = new Magazin();

        magazin.setEmails(Map.of(
                "gigel", "gigel1@mail.ro",
                "costel", "costel1@mail.ro"
        ));

        em.getTransaction().begin();

        em.persist(magazin);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
