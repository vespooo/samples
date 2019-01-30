package designpatterns.structural.bridge.api.devices;

public interface Device {

    String on();
    String off();

    boolean hasDefaultSettings();

    String setSettings();
    String addSettings(String attr, String value);
}
