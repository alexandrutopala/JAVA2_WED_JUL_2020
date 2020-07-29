package main;

import db.Marime;
import db.Material;
import db.Tricou;

import javax.persistence.Persistence;

public class Exemplu2 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c3PU");
        var em = emf.createEntityManager();

        var t = new Tricou();

        t.setMarime(Marime.M);
        t.setMaterial(Material.BUMBAC);

        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
