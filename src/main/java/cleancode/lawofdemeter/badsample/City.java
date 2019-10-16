package cleancode.lawofdemeter.badsample;

import java.util.List;

public class City {

    private List<Sight> sights;

    public List<Sight> getSights() {
        return sights;
    }

    public void setSights(List<Sight> sights) {
        this.sights = sights;
    }

}
