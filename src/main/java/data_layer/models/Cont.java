package data_layer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cont {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("parola")
    private String parola;
    private int id_client;

    public Cont(){

    }

    public Cont(String username, String parola, int id_client) {
        this.username = username;
        this.parola = parola;
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return String.format(
                "Cont[id=%d, nume='%s', prenume='%s', telefon='%s', adresa='%s']",
                id, username, parola, id_client);
    }
}
