package data_layer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "imagine")
public class Imagine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_produs;

    @JsonProperty("url")
    private String url;

    public Imagine() {

    }

    public Imagine(int id_produs, String url) {
        this.id_produs = id_produs;
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format(
                "Imagine[id=%d, url='%s', id_produs='%s']",
                id, url, id_produs);
    }
}
