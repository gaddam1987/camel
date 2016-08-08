package gaddam1987.github.learning.config;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.stream.StreamComponent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.google.common.truth.Truth.assert_;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CamelConfig.class)
public class CamelConfigTest {
    @Autowired
     CamelContext camelContext;

    @Test
    public void testCamelContextIsNotNull() {
        assert_().that(camelContext).isNotNull();
    }

    @Test
    public void camelRouteFromSysinToSysOut() throws Exception {
        //camelContext.addRoutes(new LogMessageOnTimerEventRouteBuilder());
        camelContext.addComponent("system", new StreamComponent());
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("stream:in").to("stream:out");
            }
        });

        camelContext.start();
        Thread.sleep(30000000);
    }

    class LogMessageOnTimerEventRouteBuilder extends RouteBuilder {
        @Override
        public void configure() throws Exception {
            from("timer:logMessageTimer?period=1s")
                    .log("Event triggered by ${property.CamelTimerName}"
                            + " at ${header.CamelTimerFiredTime}");
        }
    }

    @After
    public void clean() throws Exception {
        camelContext.stop();
    }
}