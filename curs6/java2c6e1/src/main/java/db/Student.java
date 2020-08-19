package db;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/*
    NamedQuery reprezinta un JPQL predefinit si validat la inceputul aplciatiei
 */
@Entity
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
@NamedQuery(name = "Student.findByNume", query = "SELECT s FROM Student s WHERE s.id.nume = :nume")
public class Student {

    @EmbeddedId
    private NumePrenumeId id;

    private String cod;

    public Student(NumePrenumeId id) {
        this.id = id;
        System.out.println("c-tor student id");
    }

    public Student() {
    }

    public NumePrenumeId getId() {
        return id;
    }

    public void setId(NumePrenumeId id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return id.getNume() + " " + id.getPrenume() + cod;
    }
}
