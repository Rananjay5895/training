package co.incubyte.co.incubyte;

import io.micronaut.context.annotation.Bean;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Bean
public class MovieService {

    private MovieGateway gateway;

    public MovieService(MovieGateway gateway) {

        this.gateway = gateway;
    }

    public List<Movie> find(String query) {
      TmdbResponse response = gateway.find(query);
//      if(response == null){
//          return Collections.EMPTY_LIST;
//      }
      return response.getResults();
    }

    public MovieDetail findById(int id) {
       return gateway.findById(id);
        }
}
