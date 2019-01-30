package designpatterns.structural.bridge.api.devices;

import org.springframework.util.Assert;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TV implements Device {

    Map<Settings, String> currentSettings;
    Map<Settings, String> defaultSettings;

    public TV() {
        this.currentSettings = new HashMap<>();
        this.defaultSettings = new HashMap<>();
    }

    @Override
    public String on() {
        return "TV is on";
    }

    @Override
    public String off() {
        return "TV is off";
    }

    @Override
    public boolean hasDefaultSettings() {
        return !defaultSettings.isEmpty();
    }

    @Override
    public String setSettings() {
        currentSettings = Stream.concat(currentSettings.entrySet().stream(), defaultSettings.entrySet().stream())
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue));
        return currentSettings.toString();
    }

    @Override
    public String addSettings(String attr, String value) {

        Assert.notNull(attr, "Settings name is null");

        String attrUpperCase = attr.toUpperCase().trim();

        Assert.notNull(Settings.valueOf(attrUpperCase), "There is no Settings with name attr");

        defaultSettings.put(Settings.valueOf(attrUpperCase), value);
        return "Setting " + attr + " set to " + value;
    }

    private enum Settings {
        VOLUME, CHANEL
    }
}
