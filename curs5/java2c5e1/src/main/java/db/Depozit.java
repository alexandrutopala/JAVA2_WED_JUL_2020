package db;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Cacheable(value = true) // activam cacheing-ul pentru query-urile facute pe entitatea Depozit
public class Depozit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection
    @MapKeyJoinColumn(name = "adresa_id") // configuram coloana la care este mapata legatura catre Adresa
    private Map<Adresa, String> firme = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Adresa, String> getFirme() {
        return firme;
    }

    public void setFirme(Map<Adresa, String> firme) {
        this.firme = firme;
    }
}
