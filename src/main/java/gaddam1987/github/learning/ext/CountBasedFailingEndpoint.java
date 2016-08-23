package gaddam1987.github.learning.ext;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO : Copy netflix hystrix example to simulate the error
 */

public class CountBasedFailingEndpoint {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    void failConsecutivelyForEvery10RequestsWithReducingRange() {

    }
}
