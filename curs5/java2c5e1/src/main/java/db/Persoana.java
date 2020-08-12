package db;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Persoana {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "persoana")
    @MapKey(name = "strada") // specifica numele fieldului din entitatea Adresa
                             // a carui valoare va fi pusa drept cheie asociata Adresei
    @MapKeyColumn(name = "cod_pers")
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
