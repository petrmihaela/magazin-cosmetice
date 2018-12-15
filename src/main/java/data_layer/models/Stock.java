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

    @JsonProperty("produsid")
    private int produsid;

    public Stock() {

    }

    public Stock(String culoare, int cantitate, int id_produs) {
        this.culoare = culoare;
        this.cantitate = cantitate;
        this.produsid = id_produs;
    }

    @Override
    public String toString() {
        return String.format(
                "Stock[id=%d, culoare='%s', cantitate='%s', produsId='%s']",
                id, culoare, cantitate, produsid);
    }
}
