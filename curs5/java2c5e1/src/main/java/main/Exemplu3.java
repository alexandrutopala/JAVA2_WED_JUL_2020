package main;

import db.Marime;
import db.Tricou;

import javax.persistence.Persistence;
import java.util.Map;

public class Exemplu3 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        var tricou = new Tricou();

        tricou.setModele(Map.of(
                Marime.M, "simplu",
                Marime.S, "in dungi"
        ));

        em.getTransaction().begin();

        em.persist(tricou);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
