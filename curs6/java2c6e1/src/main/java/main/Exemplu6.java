package main;

import db.Departament;
import db.Programator;

import javax.persistence.Persistence;
import java.util.Set;

public class Exemplu6 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        var p1 = new Programator();

        p1.setLimbaj("java");
        p1.setNume("gigel");

        var p2 = new Programator();

        p2.setLimbaj("C#");
        p2.setNume("costel");

        var d = new Departament();

        d.setProgramatori(Set.of(p1, p2));

        em.getTransaction().begin();

        em.persist(d);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
