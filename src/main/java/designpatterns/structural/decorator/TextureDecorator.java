package designpatterns.structural.decorator;

public class TextureDecorator implements Component {

    private Component decorator;
    private String texture;

    public TextureDecorator(Component decorator, String texture) {
        this.decorator = decorator;
        this.texture = texture;
    }

    @Override
    public String decorate() {
        return decorator.decorate() + " with " + texture + " texture";
    }
}
