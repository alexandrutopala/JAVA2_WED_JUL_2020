package main;

import db.Marime;
import db.Tricou;

import javax.persistence.Persistence;

public class Exemplu8 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c3PU");
        var em = emf.createEntityManager();

        var t = em.find(Tricou.class, 2);

        t.setMarime(Marime.XL);

        // refresh actualizeaza valorile atributelor lui t
        // cu cele care exista in baza de date
        em.refresh(t);

        System.out.println(t);

        em.close();
        emf.close();
    }
}
