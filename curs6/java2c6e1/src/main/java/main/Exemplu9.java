package main;

import db.Student;

import javax.persistence.Persistence;

public class Exemplu9 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        var query = em.createQuery("SELECT new Student(s.id) FROM Student s", Student.class);

        query.getResultList().forEach(System.out::println);
    }
}
