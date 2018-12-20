package data_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoggedClient {

    @JsonProperty("id")
    private int id;
    @JsonProperty("nume")
    private String nume;
    @JsonProperty("prenume")
    private String prenume;
    @JsonProperty("telefon")
    private String telefon;
    @JsonProperty("adresa")
    private String adresa;

    public LoggedClient() {

    }

    public LoggedClient(int id, String nume, String prenume, String telefon, String adresa) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return String.format(
                "Client[ id='%d', nume='%s', prenume='%s', telefon='%s', adresa='%s']",
                id, nume, prenume, telefon, adresa);
    }
}
