package main;

import db.Student;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


/*
    Observatii:
    - JPQL nu accepta inserturi
    - JPQL (si query-urile native) nu actualizeaza contextul de persistenta
 */
public class Exemplu5 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        // SELECT * FROM student (nativ)
        // SELECT s FROM Student s (JPQL)

        TypedQuery<Student> query =
                em.createQuery("SELECT s FROM Student s WHERE s.id.nume = ?0 AND s.id.prenume = :prenume", Student.class);

        // in JPQL putem defini parametri de tipul:
        // - index: (?0)
        // - named: (:prenume)

        query.setParameter(0, "ion");
        query.setParameter("prenume", "gigel");

        List<Student> studenti = query.getResultList();

        studenti.forEach(System.out::println);

        // named queries
        System.out.println("==================");

        var query2 = em.createNamedQuery("Student.findAll", Student.class);

        query2.getResultList().forEach(System.out::println);
    }
}
