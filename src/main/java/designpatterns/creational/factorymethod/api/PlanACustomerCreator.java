package designpatterns.creational.factorymethod.api;

public class PlanACustomerCreator implements CustomerCreator {
    @Override
    public Plan createPlan() {
        return new PlanA();
    }
}
