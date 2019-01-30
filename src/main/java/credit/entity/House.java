package credit.entity;

import org.joda.money.Money;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.joda.money.CurrencyUnit.USD;

public class House {
    private int amount;
    private int hoa;
    private double monthlyTax;
    private int monthlyInsurance;

    public House(int amount, int hoa, double homeTax, int monthlyInsurance) {
        this.amount = amount;
        this.hoa = hoa;
        this.monthlyTax = calculateMonthlyTaxAmount(amount, homeTax);
        this.monthlyInsurance = monthlyInsurance;
    }

    private double calculateMonthlyTaxAmount(int amount, double homeTax) {
        return (amount * homeTax / 100) / 12;
    }

    public int getAmount() {
        return amount;
    }

    public int getHoa() {
        return hoa;
    }

    public double getMonthlyTax() {
        return monthlyTax;
    }

    public int getMonthlyInsurance() {
        return monthlyInsurance;
    }

    public double calculateExpenses() {
        return monthlyTax + hoa + monthlyInsurance;
    }
}
