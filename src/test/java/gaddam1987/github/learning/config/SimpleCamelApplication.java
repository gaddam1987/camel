package gaddam1987.github.learning.config;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.CountDownLatch;

/**
 * Created by svn_admin on 23/08/2016.
 */
public class SimpleCamelApplication {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new LogMessageOnTimerEventRouteBuilder(countDownLatch));

        context.start();

        countDownLatch.await();
        Thread.sleep(4000);
        context.stop();
    }
}
