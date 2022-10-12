package co.incubyte.co.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class MovieControllerTest {

    @Inject
    @Client("/movies")
    HttpClient client;

    @Test
    @DisplayName("Should Return List Of Movies on find method")
    public void should_return_list_of_movies_on_find_method() {
      List<Movie> movies =  client.toBlocking().retrieve(HttpRequest.GET("?query=titanic"), Argument.listOf(Movie.class));
        assertThat(movies.size()).isNotZero();
        Movie movie = movies.get(0);
        assertThat(movie.getName()).isEqualTo("Titanic 666");
        assertThat(movie.getImage()).isEqualTo("/EX0ITg5YqDgFHjujpTNhEPaJSL.jpg");
        assertThat(movie.getDate()).isEqualTo("2022-04-15");
        assertThat(movie.getRating()).isEqualTo(6.1f);
        assertThat(movie.getCount()).isEqualTo(103);
    }
}
