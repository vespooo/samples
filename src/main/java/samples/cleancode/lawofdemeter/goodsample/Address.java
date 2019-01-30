package samples.cleancode.lawofdemeter.goodsample;

public class Address {
    private City city;
    private String street;
    private String home;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city=" + city +
                ", street='" + street + '\'' +
                ", home='" + home + '\'' +
                '}';
    }


    public void printRelatedSights() {
        //don't know about city details, just ask city to do smth
        city.printRelatedSights();
    }
}
