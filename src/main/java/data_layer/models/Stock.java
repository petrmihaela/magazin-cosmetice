package data_layer.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("culoare")
    private String culoare;

    @JsonProperty("cantitate")
    private int cantitate;

    private int id_produs;

    public Stock() {

    }

    public Stock(String culoare, int cantitate, int id_produs) {
        this.culoare = culoare;
        this.cantitate = cantitate;
        this.id_produs = id_produs;
    }

    @Override
    public String toString() {
        return String.format(
                "Stock[id=%d, culoare='%s', cantitate='%s', id_produs='%s']",
                id, culoare, cantitate, id_produs);
    }
}
