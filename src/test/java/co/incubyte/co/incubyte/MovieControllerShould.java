package co.incubyte.co.incubyte;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieControllerShould {
    @Mock
    MovieService service;

    @Test
    @DisplayName("should invoke find method of service")
    public void should_invoke_find_method_of_service() {

        MovieController controller = new MovieController(service);
        controller.find("titanic");
        verify(service).find("titanic");

    }
}
