package cleancode.lawofdemeter.goodsample;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String...args){
        Address address = new Address();

        City city = new City();
        city.setName("CityA");

        Sight sight1 = new Sight();
        sight1.setName("SightA");
        Sight sight2 = new Sight();
        sight2.setName("SightB");

        List<Sight> sights = new ArrayList<>();
        sights.add(sight1);
        sights.add(sight2);

        city.setSights(sights);

        address.setCity(city);
        address.printRelatedSights();//not get info, it should do smth, but shouldn't know details

    }

}
