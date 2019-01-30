package designpatterns.creational.factorymethod.api;


public class Customer {

    private String name;
    private Plan plan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}

