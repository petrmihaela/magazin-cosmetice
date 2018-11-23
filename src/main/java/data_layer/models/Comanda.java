package data_layer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comanda")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pret_total")
    @JsonProperty("pretTotal")
    private int pretTotal;

    @Column(name = "data_comanda")
    @JsonProperty("dataComanda")
    private Date dataComanda;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private int id_client;

    public Comanda(){

    }

    public Comanda(int pretTotal, Date dataComanda, int id_client) {
        this.pretTotal = pretTotal;
        this.dataComanda = dataComanda;
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return String.format(
                "Comanda[id=%d, pret='%s', data='%s', id_client='%s']",
                id, pretTotal, dataComanda, id_client);
    }
}
