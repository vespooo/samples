package designpatterns.creational.factorymethod.api;

public interface CustomerCreator {

    default Customer createCustomer(){
        Customer customer = new Customer();
        customer.setName("Name");
        customer.setPlan(createPlan());
        return customer;
    }

    Plan createPlan();
}
