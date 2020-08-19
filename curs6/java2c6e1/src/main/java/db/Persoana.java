package db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(NumePrenumeId.class) // clasa ce reprezinta cheia primara compusa
// Cand folosim IdClass trebuie sa redefinim toate atributele din clasa ce
// reprezinta cheia primara compusa si sa le adnotam cu @Id
public class Persoana {

    @Id
    private String nume;

    @Id
    private String prenume;

    private int varsta;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
