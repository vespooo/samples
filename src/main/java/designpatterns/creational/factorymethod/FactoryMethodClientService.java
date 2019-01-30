package designpatterns.creational.factorymethod;

import designpatterns.creational.factorymethod.api.Customer;

public interface FactoryMethodClientService {
    Customer createPlanACustomer();

    Customer createPlanBCustomer();
}
