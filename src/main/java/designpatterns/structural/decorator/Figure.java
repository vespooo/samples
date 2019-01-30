package designpatterns.structural.decorator;

public class Figure implements Component{

    private String x;
    private String y;

    public Figure(String x, String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String decorate() {
        return "Figure with (" + x + "," + y + ") location created, ";
    }
}
