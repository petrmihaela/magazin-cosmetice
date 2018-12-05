package data_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoggedClient {

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

    public LoggedClient(String nume, String prenume, String telefon, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return String.format(
                "Client[ nume='%s', prenume='%s', telefon='%s', adresa='%s']",
                nume, prenume, telefon, adresa);
    }
}
