package db;

import javax.persistence.*;

@Entity
public class Angajat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    // Angajat many to one Departament
    // cascade specifica ce operatii ale EntityManagereului aplicate pe Angajat sa fie
    // mai departe cascadate pe Departament
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_dep") // folosim JoinColumn pentru a configura o coloana ce mapeaza o relatie
                                 // (asemanator cu @Column)
    private Departament departament;

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

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
