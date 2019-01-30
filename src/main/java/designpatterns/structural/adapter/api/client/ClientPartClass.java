package designpatterns.structural.adapter.api.client;

public class ClientPartClass implements TargetInterface {
    @Override
    public String clientMethod() {
        return "client";
    }
}
