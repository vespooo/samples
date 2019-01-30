package multithreading;

import multithreading.api.producerconsumer.Producer;
import multithreading.api.producerconsumer.Product;
import org.junit.jupiter.api.Test;

public class ProducerConsumerTest {

    @Test
    public void test(){
        new Producer(new Product());

    }
}
