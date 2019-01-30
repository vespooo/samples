package designpatterns.structural.adapter.api.client;

import designpatterns.structural.adapter.api.thirdpartylib.ThirdPartyInterface;

public class IntegratedFromThirdPartyClass implements TargetInterface {
    ThirdPartyInterface thirdPartyInterface;

    public IntegratedFromThirdPartyClass(ThirdPartyInterface thirdPartyInterface) {
        this.thirdPartyInterface = thirdPartyInterface;
    }

    @Override
    public String clientMethod() {
        String thirdPartyData = thirdPartyInterface.thirdPartyMethod();
        return thirdPartyData;
    }
}
