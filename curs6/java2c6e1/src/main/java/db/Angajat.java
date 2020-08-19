package db;

import javax.persistence.*;

@MappedSuperclass // declara ca Angajat va fi mostenit de entitati, dar Angajatul in sine
                  // nu este o entitate
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Angajat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
