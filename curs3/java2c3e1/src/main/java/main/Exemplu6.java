package main;

import db.Tricou;

import javax.persistence.Persistence;

public class Exemplu6 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c3PU");
        var em = emf.createEntityManager();

        var t = new Tricou();

        t.setId(2);

        // adaugam instanta t in contextul de persistenta
        // Obs.: nu folosim persist deoarece em ar adauga
        // o noua instanta in baza de date
        t = em.merge(t);

        System.out.println(t);
    }
}
