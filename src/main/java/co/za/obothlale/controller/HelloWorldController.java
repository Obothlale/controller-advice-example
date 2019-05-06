package co.za.obothlale.controller;

import co.za.obothlale.model.Greeting;
import co.za.obothlale.service.impl.HelloWorldServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private HelloWorldServiceImpl helloWorldServiceImpl;

    @Autowired
    public HelloWorldController(HelloWorldServiceImpl helloWorldServiceImpl) {
        this.helloWorldServiceImpl = helloWorldServiceImpl;
    }

    @GetMapping("/hello/{world}")
    public Greeting getGreeting(@PathVariable("world") String world) {
        return helloWorldServiceImpl.getGreeting(world);
    }

}
