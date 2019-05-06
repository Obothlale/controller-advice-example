package co.za.obothlale.service.impl;

import co.za.obothlale.exception.NoWorldMentionedToGreetException;
import co.za.obothlale.model.Greeting;
import co.za.obothlale.service.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    public Greeting getGreeting(String world){
        if (world.length() > 2) {
            return new Greeting("Hello " + world);
        }
        throw new NoWorldMentionedToGreetException("Invalid world name with character length: " + world.length() + ". At least 3 characters needed to greet that world!");
    }
}
