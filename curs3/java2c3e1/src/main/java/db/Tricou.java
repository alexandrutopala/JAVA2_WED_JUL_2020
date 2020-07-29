package db;

import javax.persistence.*;

@Entity
public class Tricou {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // avem doua variante de a stoca valoarea unui enum: ordinal sau name
    @Enumerated(EnumType.ORDINAL)
    private Marime marime;

    // optional = false nu adauga constrangeri la nivel de baza de date, ci doar
    // la nivel de aplicatie
    // fetch - specifica daca un atribut anume trebuie adus din baza de date
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Material material;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Marime getMarime() {
        return marime;
    }

    public void setMarime(Marime marime) {
        this.marime = marime;
    }

    @Override
    public String toString() {
        return "Tricou{" +
                "id=" + id +
                ", marime=" + marime +
                '}';
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
