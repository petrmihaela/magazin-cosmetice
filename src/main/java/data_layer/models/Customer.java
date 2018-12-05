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
    @JsonProperty("username")
    private String username;
    @JsonProperty("parola")
    private String parola;

    public Customer() {

    }

    public Customer(String nume, String prenume, String telefon, String adresa, String username, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.adresa = adresa;
        this.username = username;
        this.parola = parola;
    }

    @Override
    public String toString() {
        return String.format(
                "Client[id=%d, nume='%s', prenume='%s', telefon='%s', adresa='%s', username='%s', parola='%s']",
                id, nume, prenume, telefon, adresa, username, parola);
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getUsername() {
        return username;
    }

    public String getParola() {
        return parola;
    }
}
