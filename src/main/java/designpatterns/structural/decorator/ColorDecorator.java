package designpatterns.structural.decorator;

public class ColorDecorator implements Component{

    private Component decorator;
    private String color;

    public ColorDecorator(Component decorator, String color) {
        this.decorator = decorator;
        this.color = color;
    }

    @Override
    public String decorate() {
        return decorator.decorate() + " with " + color + " color";
    }
}
