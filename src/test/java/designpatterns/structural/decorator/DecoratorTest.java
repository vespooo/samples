package designpatterns.structural.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DecoratorTest {

    @Test
    void test() {
        Component decoratedComponent = new ShapeDecorator(new ColorDecorator(new TextureDecorator(new Figure("100", "200"), "line"), "blue"), "citcle");
        Assertions.assertEquals("Figure with (100,200) location created,  with line texture with blue color with citcle shape", decoratedComponent.decorate());
    }

}
