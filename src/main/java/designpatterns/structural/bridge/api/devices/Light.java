package designpatterns.structural.bridge.api.devices;

import org.springframework.util.Assert;

public class Light implements Device {

    private String color;
    private String intensity;
    private String defaultColor;
    private String defaultIntensity;

    public Light() {
        this.defaultColor = "yellow";
        this.defaultIntensity = "low";
    }

    @Override
    public String on() {
        return "Light is on";
    }

    @Override
    public String off() {
        return "Light is off";
    }

    @Override
    public boolean hasDefaultSettings() {
        return true;
    }

    @Override
    public String setSettings() {
        this.color = this.defaultColor;
        this.intensity = this.defaultIntensity;
        return "color=" + color + " and intensity=" + intensity;
    }

    @Override
    public String addSettings(String attr, String value) {
        Assert.notNull(attr, "Settings name is null");
        if("color".equals(attr.toLowerCase().trim())){
            this.defaultColor=value;
        } else if("intensity".equals(attr.toLowerCase().trim())){
            this.defaultIntensity = value;
        } else throw new IllegalArgumentException();
        return attr + "=" +value;
    }
}
