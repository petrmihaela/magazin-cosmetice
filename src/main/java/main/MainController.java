package main;

import data_layer.dto.ClientDto;
import data_layer.dto.LoggedClient;
import data_layer.dto.ProductDto;
import data_layer.exceptions.NotFoundException;
import data_layer.models.Customer;
import data_layer.models.Imagine;
import data_layer.models.Produs;
import data_layer.models.Stock;
import data_layer.services.ClientService;
import data_layer.services.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MainController {

    @Autowired
    ProdusService productService;

    @Autowired
    ClientService clientService;
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
       List<Stock> stocks=productService.getStocksForAProduct(produsId);
       return stocks;
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
