package lib.dto;

import java.io.Serializable;

public class ProdusDto implements Serializable {

    private int id;

    private String nume;

    private double pret;

    private Categorie categorie;

    public ProdusDto(String nume, double pret, Categorie categorie) {
        this.nume = nume;
        this.pret = pret;
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "ProdusDto{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", pret=" + pret +
                ", categorie=" + categorie +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
