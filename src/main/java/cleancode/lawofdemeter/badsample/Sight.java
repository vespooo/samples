package cleancode.lawofdemeter.badsample;

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
}
