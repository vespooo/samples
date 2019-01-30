package credit.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import  javax.script.AbstractScriptEngine;
public class Mortgage implements Cloneable{

    private double amount;
    private double percent;
    private int numberOfMonth;
    private double fixedMonthAmount;


    public Mortgage(double percent, int numberOfMonth, int downPayment, int amount) {
        this.percent = percent;
        this.numberOfMonth = numberOfMonth;
        this.amount = amount - downPayment;
    }

    double calculateFixedMonthAmount() {

        double percentMonthlyAmount = calculateMonthPercent(this.amount);
        double mainMonthlyAmount = calculateFirstMainMonthlyAmount();
        return (percentMonthlyAmount+ mainMonthlyAmount +mainMonthlyAmount)/2;
    }


    double calculateFirstMainMonthlyAmount() {
        return amount / numberOfMonth;
    }

    double calculateMainMonthlyAmount(double leftAmount) {
        return fixedMonthAmount - calculateMonthPercent(leftAmount);
    }

    private Mortgage(double percent, int numberOfMonth, int downPayment, double amount, double fixedMonthAmount) {
        this.percent = percent;
        this.numberOfMonth = numberOfMonth;
        this.amount = amount - downPayment;
        this.fixedMonthAmount = fixedMonthAmount;
    }


    public double calculateMonthPercent(double leftAmount) {
        return leftAmount*percent/(12*100);
    }

    public double getFixedMonthAmount() {
        return fixedMonthAmount;
    }

    public void applyDownPayment(double downPayment) {
        this.amount -= downPayment;
        this.fixedMonthAmount = calculateFixedMonthAmount();
    }

    public double getAmount() {
        return amount;
    }

    public int getNumberOfMonth() {
        return numberOfMonth;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
