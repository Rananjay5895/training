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
        assertThat(movie.getName()).isEqualTo("Titanic");
        assertThat(movie.getImage()).isEqualTo("/9xjZS2rlVxm8SFx8kPC3aIGCOYQ.jpg");
        assertThat(movie.getDate()).isEqualTo("1997-11-18");
        assertThat(movie.getRating()).isEqualTo(7.9f);
        assertThat(movie.getCount()).isEqualTo(21628);
        assertThat(movie.getId()).isEqualTo(597);
    }

    @Test
    @DisplayName("Should return data of movie based on its id")
    public void should_return_data_of_movie_based_on_its_id() {
        MovieDetail movie = client.toBlocking().retrieve(HttpRequest.GET("/597"), MovieDetail.class);
        assertThat(movie).isNotNull();
        assertThat(movie.getName()).isEqualTo("Titanic");
        assertThat(movie.getImage()).isEqualTo("/9xjZS2rlVxm8SFx8kPC3aIGCOYQ.jpg");
        assertThat(movie.getDate()).isEqualTo("1997-11-18");
        assertThat(movie.getCount()).isEqualTo(21628);
        assertThat(movie.getRating()).isEqualTo(7.876f);
        assertThat(movie.getDescription()).isNotNull();
        assertThat(movie.getBackgroundImage()).isEqualTo("/3WjbxaqYB4vAbdUfdr5vbglD2JZ.jpg");
        assertThat(movie.getPopularity()).isEqualTo(149.117f);
        assertThat(movie.getLanguage()).isEqualTo("en");
    }
}
