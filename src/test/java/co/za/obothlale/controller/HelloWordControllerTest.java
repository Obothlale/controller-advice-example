package co.za.obothlale.controller;

import co.za.obothlale.Application;
import co.za.obothlale.exception.NoWorldMentionedToGreetException;
import co.za.obothlale.model.Greeting;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = Application.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWordControllerTest {

    @Autowired
    private HelloWorldController helloWorldController;

    @Test
    public void testHelloWorld() {
        String world = "Earth";
        String expectedGreeting = "Hello " + world;
        Greeting greeting = helloWorldController.getGreeting(world);
        Assert.assertEquals(expectedGreeting, greeting.getMessage());
    }

    @Test(expected = NullPointerException.class)
    public void testHelloWorldNullWorld() {
        helloWorldController.getGreeting(null);
    }

    @Test(expected = NoWorldMentionedToGreetException.class)
    public void testHelloWorldEmptyWorld() {
        helloWorldController.getGreeting("");
    }
}
