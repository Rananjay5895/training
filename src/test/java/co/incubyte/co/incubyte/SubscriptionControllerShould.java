package co.incubyte.co.incubyte;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SubscriptionControllerShould {
    @Mock
    SubscriptionService subscriptionService;

    @Test
    @DisplayName("it should invoke the save method of service")
    public void it_should_invoke_the_save_method_of_service() {
        Subscriber subscriber = new Subscriber("rananjay.singh5895@gmail.com", "Rananjay", "Singh");
        SubscriptionController subscriptionController = new SubscriptionController(subscriptionService);
        subscriptionController.save(subscriber);
        Mockito.verify(subscriptionService).save(subscriber);
    }

    @Test
    @DisplayName("get subscriber by id should call newletter repository")
    public void get_subscriber_by_id_should_call_newletter_repository() {
        Subscriber subscriber = new Subscriber("rananjay.singh5895@gmail.com", "Rananjay", "Singh");
        SubscriptionController subscriptionController = new SubscriptionController(subscriptionService);
        subscriptionController.getSubscriberBy(1L);
        Mockito.verify(subscriptionService).getSubscriberBy(1L);
    }
}
