package main;

import db.Animal;
import db.Caine;
import db.Pisica;

import javax.persistence.Persistence;

public class Exemplu1 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        var animal = new Animal();

        animal.setNume("Tom");

        var pisica = new Pisica();

        pisica.setNume("mitzi");
        pisica.setVieti(9);

        var caine = new Caine();

        caine.setNume("Rex");
        caine.setVarsta(5);

        em.getTransaction().begin();

        em.persist(animal);
        em.persist(pisica);
        em.persist(caine);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
