package data_layer.dto;

import java.util.List;

public class OrderDto {

    private int idClient;
    private List<OrderedProduct> products;

    public OrderDto() {

    }

    public OrderDto(int idClient, List<OrderedProduct> products) {
        this.idClient = idClient;
        this.products = products;
    }

    public int getIdClient() {
        return idClient;
    }

    public List<OrderedProduct> getProducts() {
        return products;
    }
}
