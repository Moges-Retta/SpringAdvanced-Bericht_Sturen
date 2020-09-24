package be.vdab.catalogus.domain;

import javax.persistence.*;

@Entity
@Table(name = "artikelsgemaakt")
public class ArtikelGemaaktTable {
    @Id
    private long id;
    private String naam;

    protected ArtikelGemaaktTable(){}

    public ArtikelGemaaktTable(Artikel artikel) {
        id = artikel.getId();
        naam = artikel.getNaam();
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
