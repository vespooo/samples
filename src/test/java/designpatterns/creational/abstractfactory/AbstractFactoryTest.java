package designpatterns.creational.abstractfactory;

import designpatterns.creational.abstractfactory.api.anotherlib.AnotherLibButton;
import designpatterns.creational.abstractfactory.api.anotherlib.AnotherLibFactory;
import designpatterns.creational.abstractfactory.api.anotherlib.AnotherLibLabel;
import designpatterns.creational.abstractfactory.api.Button;
import designpatterns.creational.abstractfactory.api.Label;
import designpatterns.creational.abstractfactory.api.UIFactory;
import designpatterns.creational.abstractfactory.api.somelib.SomeLibButton;
import designpatterns.creational.abstractfactory.api.somelib.SomeLibFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

import designpatterns.creational.abstractfactory.api.somelib.SomeLibLabel;
import org.junit.jupiter.api.Test;


class AbstractFactoryTest {
    private UIFactory factory;
    @Test
    void testSomeLibFactory() throws ClassNotFoundException {

        factory = new SomeLibFactory();
        Button button = factory.createButton();
        assertEquals(SomeLibButton.class.getSimpleName(), button.value());
        Label label = factory.createLabel();
        assertEquals(SomeLibLabel.class.getSimpleName(), label.value());
    }
    @Test
    void testAnotherLibFactory() throws ClassNotFoundException {

        factory = new AnotherLibFactory();
        Button button = factory.createButton();
        assertEquals(AnotherLibButton.class.getSimpleName(), button.value());
        Label label = factory.createLabel();
        assertEquals(AnotherLibLabel.class.getSimpleName(), label.value());
    }
}
