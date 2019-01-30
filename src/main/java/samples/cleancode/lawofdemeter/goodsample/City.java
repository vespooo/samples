package samples.cleancode.lawofdemeter.goodsample;

import java.util.List;
import java.util.stream.Collectors;

public class City {

    private String name;
    private List<Sight> sights;

    public List<Sight> getSights() {
        return sights;
    }

    public void setSights(List<Sight> sights) {
        this.sights = sights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name +
                '}';
    }

    public void printRelatedSights() {
        System.out.println(sights.stream().map(Sight::toString).collect(Collectors.toList()));
    }
}
