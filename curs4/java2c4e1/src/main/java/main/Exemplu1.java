package main;

import db.Buletin;
import db.Persoana;

import javax.persistence.Persistence;

public class Exemplu1 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c4PU");
        var em = emf.createEntityManager();

        var buletin = new Buletin();

        buletin.setCod("AB123456");

        var persoana = new Persoana();

        persoana.setNume("gigel");
        persoana.setBuletin(buletin);

        buletin.setPersoana(persoana);

        em.getTransaction().begin();

        em.persist(buletin);
        em.persist(persoana);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
