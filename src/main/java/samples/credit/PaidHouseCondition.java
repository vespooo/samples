package samples.credit;


public class PaidHouseCondition implements StopCondition{
    private double houseLeftAmount;


    @Override
    public boolean isLeft() {
        return false;
    }
}
