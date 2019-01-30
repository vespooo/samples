package designpatterns.creational.abstractfactory.api;

public interface Button {
    default String value(){
        return this.getClass().getSimpleName();
    }
}
