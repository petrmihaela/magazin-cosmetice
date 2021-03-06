package data_layer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "comanda")
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("pret_total")
    private int pret_total;

    @JsonProperty("datacomanda")
    private String datacomanda;

    @JsonProperty("id_client")
    private int id_client;

    public MyOrder() {

    }

    public MyOrder(int pret_total, String dataComanda, int id_client) {
        this.pret_total = pret_total;
        this.datacomanda = dataComanda;
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return String.format(
                "MyOrder[id=%d, pret='%d', data='%s', id_client='%d']",
                id, pret_total, datacomanda, id_client);
    }

    public int getId() {
        return id;
    }
}
