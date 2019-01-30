package designpatterns.creational.builder.api;

public interface Builder {
    void buildHeader();

    void buildBody();

    void buildBottom();

    Document getResult();
}
