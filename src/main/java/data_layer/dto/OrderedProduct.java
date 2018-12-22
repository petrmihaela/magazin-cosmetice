package data_layer.dto;

public class OrderedProduct {

    private int idProduct;
    private String color;
    private int quantity;
    private int price;

    public OrderedProduct(int idProduct, String color, int quantity, int price) {
        this.idProduct = idProduct;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getColor() {
        return color;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
