package designpatterns.structural.adapter;

import designpatterns.DesignPatternsConfig;
import designpatterns.structural.adapter.AdapterClientService;
import designpatterns.structural.adapter.api.client.ClientPartClass;
import designpatterns.structural.adapter.api.client.IntegratedFromThirdPartyClass;
import designpatterns.structural.adapter.api.client.TargetInterface;
import designpatterns.structural.adapter.api.thirdpartylib.ThirdPartyClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collection;

@SpringJUnitConfig(classes = DesignPatternsConfig.class)
public class AdapterTest {
    @Autowired
    private AdapterClientService service;

    @Test
    public void test(){
        String thirdPartyResult = service.doSmthWithClientAndThirdPartyAsOneInterface(new IntegratedFromThirdPartyClass(new ThirdPartyClass()));
        Assertions.assertEquals("third-party", thirdPartyResult);
        String clientResult = service.doSmthWithClientAndThirdPartyAsOneInterface(new ClientPartClass());
        Assertions.assertEquals("client", clientResult);
        Collection<TargetInterface> collection = service.collectClientAndThirdPartyAsOneInterface();
        Assertions.assertEquals(2, collection.size());
    }
}
