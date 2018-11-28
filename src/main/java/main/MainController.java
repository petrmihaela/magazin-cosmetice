package main;

import data_layer.dto.ProductDto;
import data_layer.models.Imagine;
import data_layer.models.Produs;
import data_layer.services.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MainController {

    @Autowired
    ProdusService productService;

   /* @RequestMapping("/products")
    @ResponseBody
    public List<Produs> getAllProducts() {

        List<Produs> products = productService.getAllProducts();
        return products;

    }*/

    @RequestMapping(value = "/products/category", method = RequestMethod.GET)
    @ResponseBody
    public List<Produs> getTypeProducts(@RequestParam(name = "nume") String nume) {

        List<Produs> p = new ArrayList<>();
        p = productService.getTypeProducts(nume);
        return p;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDto> getProductImages() {

        List<ProductDto> i;
        i = productService.getProductImages();
        return i;
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
