package main;

import data_layer.models.Produs;
import data_layer.services.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MainController {

    @Autowired
    ProdusService productService;

    @RequestMapping("/products")
    @ResponseBody
    public List<Produs> getAllProducts() {

        List<Produs> products =productService.getAllProducts();
        return products;

    }
/*
    @RequestMapping(value = "/movies/withTitle", method = RequestMethod.GET)
    @ResponseBody
    public Movie getMovieWithTitle(@RequestParam(name = "title") String t) {

        Movie m = movieService.findMovieWithTitle(t);
        return m;

    }

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
