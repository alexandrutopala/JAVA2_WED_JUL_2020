package main;

import db.Persoana;

import javax.persistence.Persistence;

public class Exemplu6 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        var persoana = em.find(Persoana.class, 401);

        persoana.getAdrese().forEach((a, b) -> System.out.println(a));

        System.out.println(persoana.getAdrese());

        em.close();
        emf.close();
    }
}
