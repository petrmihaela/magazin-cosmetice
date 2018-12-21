package data_layer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "comanda")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("pret_total")
    private int pret_total;

    @JsonProperty("data_comanda")
    private String data_comanda;

    @JsonProperty("id_client")
    private int id_client;

    public Comanda() {

    }

    public Comanda(int pret_total, String dataComanda, int id_client) {
        this.pret_total = pret_total;
        this.data_comanda = dataComanda;
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return String.format(
                "Comanda[id=%d, pret='%d', data='%s', id_client='%d']",
                id, pret_total, data_comanda, id_client);
    }

    public int getId() {
        return id;
    }
}
