package main;

import data_layer.dto.ClientDto;
import data_layer.dto.LoggedClient;
import data_layer.dto.OrderDto;
import data_layer.dto.ProductDto;
import data_layer.exceptions.NotFoundException;
import data_layer.models.*;
import data_layer.services.ClientService;
import data_layer.services.OrderService;
import data_layer.services.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


@RestController
public class MainController {

    @Autowired
    ProdusService productService;

    @Autowired
    ClientService clientService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/products/category", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDto> getTypeProducts(@RequestParam(name = "nume") String nume) {

        return productService.getTypeProducts(nume);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDto> getProductImages() {
        return productService.getProductImages();
    }

    @RequestMapping(value = "/clients/addClient", method = RequestMethod.POST)
    @ResponseBody
    public int registerCustomer(@RequestBody Customer customer) {

        return clientService.saveClient(customer);
    }

    @RequestMapping(value = "/clients/login", method = RequestMethod.POST)
    @ResponseBody
    public LoggedClient getClient(@RequestBody ClientDto customer) throws NotFoundException {

        return clientService.getClient(customer);
    }

    @RequestMapping(value = "/product/stocks", method = RequestMethod.GET)
    @ResponseBody
    public List<Stock> getStocksForAProduct(@RequestParam(name = "produsId") int produsId) {
        List<Stock> stocks = productService.getStocksForAProduct(produsId);
        return stocks;
    }

    @RequestMapping(value = "/orders/addOrder", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String addOrder(@RequestBody OrderDto order) {
        return orderService.saveOrder(order);
    }

    @RequestMapping(value = "/orders/perMonth", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Integer> getOrdersForEveryMonth() {

        return orderService.countOrdersForEveryMonth();
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public String index() {
        return "Felicitari, mi-ai descoperit aplicatia!";
    }
}
