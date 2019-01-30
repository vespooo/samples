package designpatterns.creational.factorymethod;

import designpatterns.DesignPatternsConfig;
import designpatterns.creational.factorymethod.api.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = DesignPatternsConfig.class)
public class FactoryMethodTest {

    @Autowired
    private FactoryMethodClientService service;

    @Test
    public void testPlanA(){
        Customer customer = service.createPlanACustomer();
        Assertions.assertEquals(0, customer.getPlan().calculateCost());
    }



    @Test
    public void testPlanB(){
        Customer customer = service.createPlanBCustomer();
        Assertions.assertEquals(1, customer.getPlan().calculateCost());
    }

}
