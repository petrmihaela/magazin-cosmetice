package data_layer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("nume")
    private String nume;
    @JsonProperty("prenume")
    private String prenume;
    @JsonProperty("telefon")
    private String telefon;
    @JsonProperty("adresa")
    private String adresa;

    public Customer() {

    }

    public Customer(String nume, String prenume, String telefon, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return String.format(
                "Client[id=%d, nume='%s', prenume='%s', telefon='%s', adresa='%s']",
                id, nume, prenume, telefon, adresa);
    }
}
