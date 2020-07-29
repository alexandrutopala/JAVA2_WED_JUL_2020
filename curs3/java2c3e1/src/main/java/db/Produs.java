package db;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tabela_produse") // numele tabelei la care va fi mapata entitatea Produs
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "coloana_nume")
    private String nume;

    // cand folosim java.util.Date trebuie sa precizam
    // ce fel de data reprezinta prin @Temporal
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataExpirare;

    // in cazul claselor din java.time, nu mai este necesara
    // folosirea @Temporal, deoarece JPA stie catre ce tip de data
    // sa mapeze in baza de date
    private LocalDateTime dataProducere;

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

    public Date getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(Date dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public LocalDateTime getDataProducere() {
        return dataProducere;
    }

    public void setDataProducere(LocalDateTime dataProducere) {
        this.dataProducere = dataProducere;
    }
}
