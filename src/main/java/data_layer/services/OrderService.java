package data_layer.services;

import data_layer.dto.OrderDto;
import data_layer.dto.OrderedProduct;
import data_layer.exceptions.OrderException;
import data_layer.models.MyOrder;
import data_layer.models.ProdCom;
import data_layer.models.Produs;
import data_layer.models.Stock;
import data_layer.repositories.OrderRepository;
import data_layer.repositories.ProdComRepository;
import data_layer.repositories.ProdusRepository;
import data_layer.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProdComRepository prodComRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ProdusRepository productRepository;

    private Stock getColorStock(String color, List<Stock> stocks) {
        Stock colorStock = null;

        for (Stock s : stocks) {
            if (s.getCuloare().equals(color)) {
                colorStock = s;
            }
        }

        return colorStock;
    }

    private void updateStock(Stock s, int newQuantity) {

        stockRepository.updateCantitate(newQuantity, s.getId());
    }

    private int computeTotalPrice(List<OrderedProduct> products) {
        int sum = 0;

        for (OrderedProduct p : products) {
            sum = sum + p.getPrice() * p.getQuantity();
        }

        return sum;
    }

    private String getCurrentDate() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date.toString();
    }

    private void addProdCom(int orderId, List<OrderedProduct> products) {
        for (OrderedProduct p : products) {
            ProdCom prodCom = new ProdCom(p.getIdProduct(), orderId, p.getQuantity());
            prodComRepository.save(prodCom);
        }
    }

    public String saveOrder(OrderDto orderDto) {
        List<OrderedProduct> orderedProducts = orderDto.getProducts();
        if (orderedProducts.size() > 0) {
            List<Stock> colorStocks = new ArrayList<>();

            for (OrderedProduct p : orderedProducts) {

                List<Stock> stocks = stockRepository.findByProdusidEquals(p.getIdProduct());
                Stock colorStock = getColorStock(p.getColor(), stocks);
                colorStocks.add(new Stock(colorStock.getId(), colorStock.getCuloare(), colorStock.getCantitate() - p.getQuantity(), colorStock.getProdusid()));

                if (colorStock.getCantitate() < p.getQuantity()) {
                    String productName = productRepository.getNameOfProduct(p.getIdProduct());
                    //throw new OrderException("Stock insuficient pentru produsul " + productName);
                    return "Stock insuficient pentru produsul " + productName;
                }
            }

            for (Stock s : colorStocks)
                updateStock(s, s.getCantitate());

            MyOrder newOrder = new MyOrder(computeTotalPrice(orderedProducts), getCurrentDate(), orderDto.getIdClient());
            MyOrder added = orderRepository.saveAndFlush(newOrder);

            addProdCom(added.getId(), orderedProducts);

            return "Comanda plasata cu succes!";
        }
        //throw new OrderException("Cosul este gol!");
        return "Cosul este gol!";
    }

}
