package designpatterns.structural.bridge.api.remoteconrols;

import designpatterns.structural.bridge.api.devices.Device;

public interface RemoteControl {

    String on();
    String off();
    void setDevice(Device device);
}
