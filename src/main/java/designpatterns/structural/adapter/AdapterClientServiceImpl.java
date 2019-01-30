package designpatterns.structural.adapter;

import designpatterns.structural.adapter.api.client.ClientPartClass;
import designpatterns.structural.adapter.api.client.IntegratedFromThirdPartyClass;
import designpatterns.structural.adapter.api.client.TargetInterface;
import designpatterns.structural.adapter.api.thirdpartylib.ThirdPartyClass;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AdapterClientServiceImpl implements  AdapterClientService{
    @Override
    public String doSmthWithClientAndThirdPartyAsOneInterface(TargetInterface value) {
        return value.clientMethod();
    }

    @Override
    public Collection<TargetInterface> collectClientAndThirdPartyAsOneInterface() {
        Collection<TargetInterface> list = new ArrayList<>();
        list.add(new IntegratedFromThirdPartyClass(new ThirdPartyClass()));
        list.add(new ClientPartClass());
        return list;
    }
}
