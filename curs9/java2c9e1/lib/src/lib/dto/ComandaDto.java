package lib.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class ComandaDto implements Serializable {

    private int id;

    private double total;

    private Instant timestamp;

    private AdresaDto adresa;

    private Set<String> telefoane = new HashSet<>();

    private Set<Integer> idProduse = new HashSet<>();

    public ComandaDto(double total, Instant timestamp, AdresaDto adresa, Set<String> telefoane, Set<Integer> idProduse) {
        this.total = total;
        this.timestamp = timestamp;
        this.adresa = adresa;
        this.telefoane = telefoane;
        this.idProduse = idProduse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public AdresaDto getAdresa() {
        return adresa;
    }

    public void setAdresa(AdresaDto adresa) {
        this.adresa = adresa;
    }

    public Set<String> getTelefoane() {
        return telefoane;
    }

    public void setTelefoane(Set<String> telefoane) {
        this.telefoane = telefoane;
    }

    public Set<Integer> getIdProduse() {
        return idProduse;
    }

    public void setIdProduse(Set<Integer> idProduse) {
        this.idProduse = idProduse;
    }

    @Override
    public String toString() {
        return "ComandaDto{" +
                "id=" + id +
                ", total=" + total +
                ", timestamp=" + timestamp +
                ", adresa=" + adresa +
                ", telefoane=" + telefoane +
                '}';
    }
}