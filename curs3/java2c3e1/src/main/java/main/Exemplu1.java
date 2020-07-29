package main;

import db.Produs;

import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Exemplu1 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c3PU");
        var em = emf.createEntityManager();

        var p = new Produs();

        p.setNume("ciocolata");
        p.setDataExpirare(Calendar.getInstance().getTime());
        p.setDataProducere(LocalDateTime.now());

        try {
            em.getTransaction().begin();

            em.persist(p);

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
