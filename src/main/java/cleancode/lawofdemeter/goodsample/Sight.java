package cleancode.lawofdemeter.goodsample;

public class Sight {

    private String name;
    private Address location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Sight{" +
                "name='" + name +
                '}';
    }
}
