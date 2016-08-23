package gaddam1987.github.learning.config;

import org.apache.camel.builder.RouteBuilder;

import java.util.concurrent.CountDownLatch;

/**
 * Created by svn_admin on 23/08/2016.
 */
public class LogMessageOnTimerEventRouteBuilder extends RouteBuilder {
    private CountDownLatch countDownLatch;

    public LogMessageOnTimerEventRouteBuilder(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void configure() throws Exception {
        from("direct:prefixBodyWithHello")
                .transform(simple("Hello, ${body}"))
                .to("stream:out");
        Thread.sleep(4000);
        countDownLatch.countDown();
    }
}
