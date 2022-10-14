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
        assertThat(movie.getName()).isNotNull();
        assertThat(movie.getImage()).isNotNull();
        assertThat(movie.getDate()).isNotNull();
        assertThat(movie.getRating()).isGreaterThan(0);
        assertThat(movie.getCount()).isGreaterThan(0);
        assertThat(movie.getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Should return data of movie based on its id")
    public void should_return_data_of_movie_based_on_its_id() {
        MovieDetail movie = client.toBlocking().retrieve(HttpRequest.GET("/597"), MovieDetail.class);
        assertThat(movie).isNotNull();
        assertThat(movie.getName()).isNotNull();
        assertThat(movie.getImage()).isNotNull();
        assertThat(movie.getDate()).isNotNull();
        assertThat(movie.getCount()).isGreaterThan(0);
        assertThat(movie.getRating()).isGreaterThan(0);
        assertThat(movie.getDescription()).isNotNull();
        assertThat(movie.getBackgroundImage()).isEqualTo("/3WjbxaqYB4vAbdUfdr5vbglD2JZ.jpg");
        assertThat(movie.getPopularity()).isGreaterThan(0);
        assertThat(movie.getLanguage()).isEqualTo("en");
    }
}
