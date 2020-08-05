package db;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Magazin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    @CollectionTable(name = "my_collection_table",
            joinColumns = @JoinColumn(name = "id_magazin"))
    private Collection<String> telefoane = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<String> getTelefoane() {
        return telefoane;
    }

    public void setTelefoane(Collection<String> telefoane) {
        this.telefoane = telefoane;
    }
}
