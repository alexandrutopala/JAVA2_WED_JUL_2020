package main;

import db.NumePrenumeId;
import db.Persoana;
import db.Student;

import javax.persistence.Persistence;
import java.util.Set;

public class Exemplu3 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        var id = new NumePrenumeId();

        id.setPrenume("gigel2");
        id.setNume("ion2");

        var persoana = new Persoana();

        persoana.setNume(id.getNume());
        persoana.setPrenume(id.getPrenume());
        persoana.setVarsta(25);

        var student = new Student();

        student.setId(id);
        student.setCod("nume_student");

        em.getTransaction().begin();

        em.persist(persoana);
        em.persist(student);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
