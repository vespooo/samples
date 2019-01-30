package designpatterns.structural.adapter.api.thirdpartylib;

public class ThirdPartyClass implements ThirdPartyInterface {
    @Override
    public String thirdPartyMethod() {
        return "third-party";
    }
}
