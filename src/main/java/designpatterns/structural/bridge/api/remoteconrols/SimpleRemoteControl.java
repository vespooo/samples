package designpatterns.structural.bridge.api.remoteconrols;

import designpatterns.structural.bridge.api.devices.Device;

public class SimpleRemoteControl implements RemoteControl {

    private Device device;

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public String on() {
        return device.on();
    }

    @Override
    public String off() {
        return device.off();
    }

}
