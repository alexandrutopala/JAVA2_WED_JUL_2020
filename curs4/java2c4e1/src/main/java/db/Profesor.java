package db;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "profesori")
    private Collection<Student> studenti = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(Collection<Student> studenti) {
        this.studenti = studenti;
    }
}
