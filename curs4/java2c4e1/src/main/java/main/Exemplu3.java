package main;

import db.Departament;

import javax.persistence.Persistence;

public class Exemplu3 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c4PU");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

        var departament = em.find(Departament.class, 1);

        departament.getAngajati().removeIf(angajat -> angajat.getNume().equals("costel"));

        em.getTransaction().commit();
    }
}
