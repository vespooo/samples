package designpatterns.structural.decorator;

public class ShapeDecorator implements Component{

    private Component decorator;
    private String shape;

    public ShapeDecorator(Component decorator, String shape) {
        this.decorator = decorator;
        this.shape = shape;
    }

    @Override
    public String decorate() {
        return decorator.decorate() + " with " + shape + " shape";
    }
}
