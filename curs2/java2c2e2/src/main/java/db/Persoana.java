package db;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class Persoana {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Access(AccessType.PROPERTY)
    private String nume;

    private int varsta;

    // JPA cere un constructor fara parametrii

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("setter id");
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        System.out.println("setter nume");
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        System.out.println("setter varsta");
        this.varsta = varsta;
    }
}
