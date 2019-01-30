package designpatterns.creational.abstractfactory.api;

public interface Label {
    default String value(){
        return this.getClass().getSimpleName();
    }
}
