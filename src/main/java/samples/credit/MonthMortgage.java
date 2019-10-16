package samples.credit;

import samples.credit.entity.House;
import samples.credit.entity.Mortgage;

public class MonthMortgage {

    private int monthNumber;
    private double amountLeft;
    private double mainAmount;
    private double percentAmount;
    private double additionalPayment;
    private double overpaid;
    private double collectedAmount;

    private MonthMortgage(House house, Mortgage mortgage) {
        this.monthNumber = 0;
        this.percentAmount = 0;
        this.mainAmount = 0;
        this.additionalPayment = 0;
        this.amountLeft = mortgage.getAmount();
        this.overpaid = 0;
        this.collectedAmount = 0;
    }

    public MonthMortgage(Mortgage mortgage, int additionalPayment, MonthMortgage previousMonthMortgage) {
        this.monthNumber = previousMonthMortgage.monthNumber+1;
        this.percentAmount = mortgage.calculateMonthPercent(previousMonthMortgage.getAmountLeft());
        this.mainAmount = mortgage.getFixedMonthAmount()- this.percentAmount;
        this.additionalPayment = additionalPayment;
        this.amountLeft = previousMonthMortgage.getAmountLeft()-this.mainAmount- additionalPayment;
        this.overpaid = previousMonthMortgage.getOverpaid() + this.percentAmount;
        this.collectedAmount = previousMonthMortgage.getCollectedAmount()+ this.mainAmount + this.additionalPayment;
    }

    public double getCurrentMonthCollectedAmount() {
        return this.mainAmount + this.additionalPayment;
    }

    public double getAmountLeft() {
        return amountLeft;
    }

    public double getMainAmount() {
        return mainAmount;
    }

    public double getPercentAmount() {
        return percentAmount;
    }

    public double getAdditionalPayment() {
        return additionalPayment;
    }

    public double getOverpaid() {
        return overpaid;
    }

    public double getCollectedAmount() {
        return collectedAmount;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public static MonthMortgage nullMortgage(House house, Mortgage mortgage) {
        return new MonthMortgage(house, mortgage);
    }
}
