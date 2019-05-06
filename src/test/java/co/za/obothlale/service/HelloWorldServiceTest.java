package co.za.obothlale.service;

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
public class HelloWorldServiceTest {
    @Autowired
    private HelloWorldService helloWorldService;

    @Test
    public void testHelloWorld() {
        String world = "Earth";
        String expectedGreeting = "Hello " + world;
        Greeting greeting = helloWorldService.getGreeting(world);
        Assert.assertEquals(expectedGreeting, greeting.getMessage());
    }

    @Test(expected = NullPointerException.class)
    public void testHelloWorldNullWorld() {
        helloWorldService.getGreeting(null);
    }

    @Test(expected = NoWorldMentionedToGreetException.class)
    public void testHelloWorldEmptyWorld() {
        helloWorldService.getGreeting("");
    }
}
