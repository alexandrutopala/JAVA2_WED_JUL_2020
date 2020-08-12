package db;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Organizatie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "organizatie")
    @MapKeyColumn(name = "cod_org")
    private Map<String, Adresa> adrese = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Adresa> getAdrese() {
        return adrese;
    }

    public void setAdrese(Map<String, Adresa> adrese) {
        this.adrese = adrese;
    }
}
