package samples.credit.entity;

public class Rent {
    private final int freeAmount;
    private int rentCost;

    public Rent(int rentCost, int freeAmount) {
        this.rentCost = rentCost;
        this.freeAmount = freeAmount;
    }

    public int getFreeAmount() {
        return freeAmount;
    }

    public int getRentCost() {
        return rentCost;
    }
}
