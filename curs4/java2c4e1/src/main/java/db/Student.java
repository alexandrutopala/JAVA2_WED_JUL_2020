package db;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "student_profesor",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_profesor")
    )
    private Collection<Profesor> profesori = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Profesor> getProfesori() {
        return profesori;
    }

    public void setProfesori(Collection<Profesor> profesori) {
        this.profesori = profesori;
    }
}
