package designpatterns.creational.abstractfactory.api.somelib;

import designpatterns.creational.abstractfactory.api.Button;
import designpatterns.creational.abstractfactory.api.Label;
import designpatterns.creational.abstractfactory.api.UIFactory;

public class SomeLibFactory implements UIFactory {
    public Button createButton() {
        return new SomeLibButton();
    }

    public Label createLabel() {
        return new SomeLibLabel();
    }
}
