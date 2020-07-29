package db;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// Adresa nu este o entitate =>
//  - nu are o tabela a ei
//  - nu are id
@Embeddable
public class Adresa {

    @Column(name = "nr_strada")
    private String strada;

    private int numar;

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }
}
