package designpatterns.structural.bridge;

import designpatterns.structural.bridge.api.devices.Device;
import designpatterns.structural.bridge.api.devices.Light;
import designpatterns.structural.bridge.api.devices.TV;
import designpatterns.structural.bridge.api.remoteconrols.AdvancedRemoteControl;
import designpatterns.structural.bridge.api.remoteconrols.RemoteControl;
import designpatterns.structural.bridge.api.remoteconrols.SimpleRemoteControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    void testSimpleRemoteControl(){
        RemoteControl rc = new SimpleRemoteControl();
        rc.setDevice(new TV());
        Assertions.assertEquals("TV is on", rc.on());
        Assertions.assertEquals("TV is off", rc.off());

        rc.setDevice(new Light());
        Assertions.assertEquals("Light is on", rc.on());
        Assertions.assertEquals("Light is off", rc.off());
    }

    @Test
    void testAdvancedRemoteControl(){
        RemoteControl rc = new AdvancedRemoteControl();
        Device device = new TV();
        rc.setDevice(device);
        Assertions.assertEquals("TV is on", rc.on());
        device.addSettings("Volume", "High");
        device.addSettings("Chanel", "Second");
        Assertions.assertEquals("TV is on with settings: {CHANEL=Second, VOLUME=High}", rc.on());

        device = new Light();
        rc.setDevice(device);
        Assertions.assertEquals("Light is on with settings: color=yellow and intensity=low", rc.on());
        device.addSettings("Color", "Blue");
        device.addSettings("Intensity", "5");
        Assertions.assertEquals("Light is on with settings: color=Blue and intensity=5", rc.on());
    }
}
