package designpatterns.structural.bridge.api.remoteconrols;

import designpatterns.structural.bridge.api.devices.Device;

public class AdvancedRemoteControl implements RemoteControl {

    private Device device;

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public String on() {
        String onStr = device.on();
        String preferences = "";
        if(device.hasDefaultSettings()){
            preferences = device.setSettings();
            return onStr + " with settings: " +preferences;
        }
        return onStr;
    }

    @Override
    public String off() {
        return device.off();
    }
}
