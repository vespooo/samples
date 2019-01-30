package designpatterns.creational.factorymethod.api;

public class PlanBCustomerCreator implements CustomerCreator {
    @Override
    public Plan createPlan() {
        return new PlanB();
    }
}
