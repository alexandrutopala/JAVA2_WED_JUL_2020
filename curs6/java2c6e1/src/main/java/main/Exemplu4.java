package main;

import db.Student;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Exemplu4 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        Query query = em.createNativeQuery("SELECT * FROM student", Student.class);

        List<Student> studenti = query.getResultList();

        studenti.forEach(System.out::println);
    }
}
