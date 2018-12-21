package main;

import data_layer.dto.ClientDto;
import data_layer.dto.LoggedClient;
import data_layer.dto.ProductDto;
import data_layer.exceptions.NotFoundException;
import data_layer.models.*;
import data_layer.services.ClientService;
import data_layer.services.ComandaService;
import data_layer.services.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RestController
public class MainController {

    @Autowired
    ProdusService productService;

    @Autowired
    ClientService clientService;

    @Autowired
    ComandaService comandaService;
   /* @RequestMapping("/products")
    @ResponseBody
    public List<Produs> getAllProducts() {

        List<Produs> products = productService.getAllProducts();
        return products;

    }*/

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
    public void registerCustomer(@RequestBody Customer customer) {

        clientService.saveClient(customer);
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
    public int addOrder(@RequestBody Comanda comanda) {

        return comandaService.saveComanda(comanda);

    }

    @RequestMapping(value = "/orders/addProdCom", method = RequestMethod.POST)
    @ResponseBody
    public void addProdCom(@RequestBody ProdCom prodCom) {

        comandaService.saveProdCom(prodCom);
    }

    @RequestMapping(value = "/stocks/updateStock", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public void updateStock(@RequestParam(name = "idStock") int idStock, @RequestParam(name = "cantitate") int cantitate) {
        productService.updateStock(idStock, cantitate);
    }

    /*
        @RequestMapping(value = "/movies/addMovie", method = RequestMethod.POST)
        @ResponseBody
        public void set(@RequestBody Movie movie) {

            movieService.saveMovie(movie);
        }

        @RequestMapping(value = "/movies/deleteMovie", method = RequestMethod.DELETE)
        @ResponseBody
        @Transactional
        public void deleteMovieWithId(@RequestBody long id) {
            movieService.deleteMovieById(id);
        }

        @RequestMapping(value = "/movies/updateMovie", method = RequestMethod.PUT)
        @ResponseBody
        @Transactional
        public void updateMovie(@RequestBody MovieUpdateDTO movie) {
            movieService.updateMovie(movie);
        }
    */
    @RequestMapping(value = "/")
    @ResponseBody
    public String index() {
        return "Felicitari, mi-ai descoperit aplicatia!";
    }
}
