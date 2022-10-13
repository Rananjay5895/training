package co.incubyte.co.incubyte;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceShould {

    @Mock
    SubscriptionRepository subscriptionRepository;

    @Test
    @DisplayName("should invoke save method of repository")
    public void should_invoke_save_method_of_repository() {
        Subscriber subscriber = new Subscriber("rananjay.singh5895@gmail.com", "Rananjay", "Singh");
        SubscriptionService subscriptionService = new SubscriptionService(subscriptionRepository);
        subscriptionService.save(subscriber);
        Mockito.verify(subscriptionRepository).save(subscriber);
    }

    @Test
    @DisplayName("get subscriber by id should invoke service")
    public void get_subscriber_by_id_should_invoke_service() {
        given (subscriptionRepository.findById(1L)).willReturn(Optional.of(new Subscriber()));
        SubscriptionService subscriptionService = new SubscriptionService(subscriptionRepository);
        subscriptionService.getSubscriberBy(1L);
        Mockito.verify(subscriptionRepository).findById (1L);
    }
}
