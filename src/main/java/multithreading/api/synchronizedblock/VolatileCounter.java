package multithreading.api.synchronizedblock;

public class VolatileCounter implements Counter {

    private volatile int num;

    @Override
    public void increase(){
        num++;
    }
    @Override
    public void decrease(){
        num--;
    }

    @Override
    public int getNum() {
        return num;
    }
}
