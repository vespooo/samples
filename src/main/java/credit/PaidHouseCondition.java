package credit;


import javafx.scene.paint.Stop;

public class PaidHouseCondition implements StopCondition{
    private double houseLeftAmount;


    @Override
    public boolean isLeft() {
        return false;
    }
}
