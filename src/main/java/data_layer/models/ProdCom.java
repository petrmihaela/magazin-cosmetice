package data_layer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prod_com")
public class ProdCom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("id_produs")
    private int id_produs;
    @JsonProperty("id_comanda")
    private int id_comanda;
    @JsonProperty("cantitate")
    private int cantitate;

    public ProdCom() {

    }

    public ProdCom(int id_produs, int id_comanda, int cantitate) {
        this.id_produs = id_produs;
        this.id_comanda = id_comanda;
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return String.format(
                "ProdCom [id=%d, id_produs='%d', id_comanda='%d', id_cantitate='%d']",
                id, id_produs, id_comanda, cantitate);
    }
}
