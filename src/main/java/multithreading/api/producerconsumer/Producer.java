package multithreading.api.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Producer implements  Runnable{

    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {

    }
}
