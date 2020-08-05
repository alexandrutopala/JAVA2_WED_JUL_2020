package db;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "departament", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER,
               orphanRemoval = true)
    private Collection<Angajat> angajati = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Angajat> getAngajati() {
        return angajati;
    }

    public void setAngajati(Collection<Angajat> angajati) {
        this.angajati = angajati;
    }
}
