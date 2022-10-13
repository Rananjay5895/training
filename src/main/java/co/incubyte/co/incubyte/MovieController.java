package co.incubyte.co.incubyte;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.List;

@Controller("/movies")
public class MovieController {
    private MovieService service;
    public MovieController(MovieService service) {
        this.service = service;
    }

    @Get
    public List<Movie> find(String query) {
       return service.find(query);
    }

    @Get("/{id}")
    public MovieDetail findById(@PathVariable("id") int id) {
        return service.findById(id);
    }
}
