package main;

import db.Student;

import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class Exemplu8 {

    /*
        se primeste din consola numele, prenumele si cod care pot avea
        o valoare sau pot avea valoarea "null"
     */
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();

        // SELECT s FROM Student s WHERE s.id.nume = "gigel"
        String nume = args[0].equals("null") ? null : args[0];
        System.out.println("nume = " + nume);

        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class); // echivalent cu "s" din "SELECT s FROM ..."

        var predicate = builder.conjunction(); // 1 = 1 AND ... AND ...

        if (nume != null) {
                predicate = builder.and(
                        predicate,
                        builder.equal(root.get("id").get("nume"), nume) // echivalend cu s.id.nume = :nume
                );
        }

        // predicate = 1 = 1 AND s.id.nume = "ion"

        query.where(predicate);

        List<Student> studenti = em.createQuery(query)
                .getResultList();

        studenti.forEach(System.out::println);
    }
}
