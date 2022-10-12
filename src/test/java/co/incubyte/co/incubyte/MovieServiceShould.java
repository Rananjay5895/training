package co.incubyte.co.incubyte;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceShould {

    @Mock
    MovieGateway gateway;
//
//    @Test
//    @DisplayName("Should invoke find method of gateway")
//    public void should_invoke_find_method_of_gateway() throws UnsupportedOperationException {
//        MovieService service = new MovieService(gateway);
//        service.find("titanic");
//        verify(gateway).find("titanic");
//    }

    @Test
    @DisplayName("should return list of movies on gateway find method")
    public void should_return_list_of_movies_on_gateway_find_method() {
        MovieService service = new MovieService(gateway);
        TmdbResponse response = new TmdbResponse(1, Collections.EMPTY_LIST);
        when(gateway.find("titanic")).thenReturn(response);
        List<Movie> movies = service.find("titanic");
        verify(gateway).find("titanic");
        assertThat(movies.size()).isZero();
    }
}