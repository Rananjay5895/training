package co.incubyte.co.incubyte;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class SubscriptionControllerTest {

    @Inject
    @Client("/subscribe")
    HttpClient client;

    @Test
    @DisplayName("should allow user to subscribe to newsletter")
    public void should_allow_user_to_subscribe_to_newsletter() {
        Subscriber subscriber = new Subscriber("rananjay.singh5895@gmail.com", "Rananjay", "Singh");
        Subscriber subscriberResponse = client.toBlocking().retrieve(HttpRequest.POST("/", subscriber), Subscriber.class);
        Long id = subscriberResponse.getId();
        assertThat(subscriberResponse.getId()).isGreaterThan(0);
        assertThat(subscriberResponse.getEmail()).isEqualTo("rananjay.singh5895@gmail.com");
        assertThat(subscriberResponse.getFirstName()).isEqualTo("Rananjay");
        assertThat(subscriberResponse.getLastName()).isEqualTo("Singh");

        Subscriber response = client.toBlocking().retrieve(HttpRequest.GET("/subscriber/" + id) , Subscriber.class);
        assertThat(subscriberResponse.getId()).isEqualTo( id);
        assertThat(subscriberResponse.getEmail()).isEqualTo("rananjay.singh5895@gmail.com");
        assertThat(subscriberResponse.getFirstName()).isEqualTo("Rananjay");
        assertThat(subscriberResponse.getLastName()).isEqualTo("Singh");
    }
}
