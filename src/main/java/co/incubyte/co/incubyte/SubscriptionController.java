package co.incubyte.co.incubyte;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("subscribe")
public class SubscriptionController {
    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {

        this.subscriptionService = subscriptionService;
    }

    @Post
    public Subscriber save(@Body Subscriber subscriber) {
       return subscriptionService.save(subscriber);
    }


    @Get("/subscriber/{id}")
    public Subscriber getSubscriberBy(Long id) {
        return subscriptionService.getSubscriberBy(id);
    }
}
