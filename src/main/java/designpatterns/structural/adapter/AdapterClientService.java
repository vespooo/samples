package designpatterns.structural.adapter;

import designpatterns.structural.adapter.api.client.TargetInterface;

import java.util.Collection;

public interface AdapterClientService{
    String doSmthWithClientAndThirdPartyAsOneInterface(TargetInterface value);
    Collection<TargetInterface> collectClientAndThirdPartyAsOneInterface();
}
