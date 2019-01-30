package designpatterns.creational.abstractfactory.api.anotherlib;

import designpatterns.creational.abstractfactory.api.Button;
import designpatterns.creational.abstractfactory.api.Label;
import designpatterns.creational.abstractfactory.api.UIFactory;

public class AnotherLibFactory implements UIFactory {
    public Button createButton() {
        return new AnotherLibButton();
    }

    public Label createLabel() {
        return new AnotherLibLabel();
    }
}
