package multithreading.api.synchronizedblock;

public class NotVolatileCounter implements Counter{

    private int num;

    public void increase(){
        num++;
    }
    public void decrease(){
        num--;
    }

    public int getNum() {
        return num;
    }
}
