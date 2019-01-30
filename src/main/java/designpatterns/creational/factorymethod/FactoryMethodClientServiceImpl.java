package designpatterns.creational.factorymethod;

import designpatterns.creational.factorymethod.api.Customer;
import designpatterns.creational.factorymethod.api.CustomerCreator;
import designpatterns.creational.factorymethod.api.PlanACustomerCreator;
import designpatterns.creational.factorymethod.api.PlanBCustomerCreator;
import org.springframework.stereotype.Service;

@Service
public class FactoryMethodClientServiceImpl implements FactoryMethodClientService{

    public Customer createPlanACustomer() {
        CustomerCreator customerCreator = new PlanACustomerCreator();
        return customerCreator.createCustomer();
    }

    public Customer createPlanBCustomer() {
        CustomerCreator customerCreator = new PlanBCustomerCreator();
        return customerCreator.createCustomer();
    }
}
