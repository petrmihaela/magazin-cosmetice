package data_layer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "produs")
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("nume")
    private String nume;
    @JsonProperty("pret")
    private int pret;
    @JsonProperty("descriere")
    private String descriere;

    public Produs(){

    }

    public Produs(String nume, int pret, String descriere) {
        this.nume = nume;
        this.pret = pret;
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return String.format(
                "Produs[id=%d, nume='%s', pret='%s', descriere='%s']",
                id, nume, pret, descriere);
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public int getPret() {
        return pret;
    }

    public String getDescriere() {
        return descriere;
    }
}
