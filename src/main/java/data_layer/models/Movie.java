package data_layer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JsonProperty("title")
    private String title;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("releaseDate")
    @Column(name = "released_date")
    private String releaseDate;


    protected Movie() {
    }

    public Movie(String title, String rating, String year) {
        this.title = title;
        this.rating = rating;
        this.releaseDate = year;
    }

    @Override
    public String toString() {
        return String.format(
                "Movie[id=%d, title='%s', year='%s',rating='%s']",
                id, title, releaseDate, rating);
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
