package co.incubyte.co.incubyte;

import io.micronaut.context.annotation.Bean;

import javax.persistence.EntityExistsException;

@Bean
public class SubscriptionService {
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscriber save(Subscriber subscriber) {
       return subscriptionRepository.save(subscriber);
    }

    public Subscriber getSubscriberBy(Long id) {
        return subscriptionRepository.findById(id).get();
    }
}
