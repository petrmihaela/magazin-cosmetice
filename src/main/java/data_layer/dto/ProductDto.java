package data_layer.dto;

import java.util.List;

public class ProductDto {

    private int id;
    private String nume;
    private int pret;
    private String descriere;
    private List<String> url;

    public ProductDto() {

    }

    public ProductDto(int id, String nume, int pret, String descriere, List<String> url) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.descriere = descriere;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format(
                "Produs[id=%d, nume='%s', pret='%s', descriere='%s']",
                id, nume, pret, descriere);
    }
}

