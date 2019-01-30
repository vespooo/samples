package credit.entity;

import credit.entity.Mortgage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MortgageTest {

    @Test
    public void testPercentAmount(){
        int amount = 120000;
        Mortgage mortgage = new Mortgage(1, 30, 0, amount);
        Assertions.assertEquals((double) ((amount*1/100))/12, mortgage.calculateMonthPercent(amount));
    }

    @Test
    public void testFirstMainMonthAmount(){
        int percent = 1;
        int amount = 120000;
        int downPayment = 0;
        int numberOfMonth = 30;
        Mortgage mortgage = new Mortgage(percent, numberOfMonth, downPayment, amount);
        Assertions.assertEquals(amount/30, mortgage.calculateFirstMainMonthlyAmount());
    }

    @Test
    public void testFixedMonthAmount(){
        int percent = 1;
        int amount = 120000;
        int downPayment = 0;
        int numberOfMonth = 30;
        Mortgage mortgage = new Mortgage(percent, numberOfMonth, downPayment, amount);
        double percentAmount = mortgage.calculateMonthPercent(amount);
        double mainAmount = mortgage.calculateFirstMainMonthlyAmount();

        Assertions.assertEquals((percentAmount + 2*mainAmount)/2, mortgage.calculateFixedMonthAmount());
    }

    @Test
    public void testMainMonthlyAmount(){
        int percent = 1;
        int amount = 120000;
        int downPayment = 0;
        int numberOfMonth = 30;
        Mortgage mortgage = new Mortgage(percent, numberOfMonth, downPayment, amount);
        double fixedAmount = mortgage.getFixedMonthAmount();
        double percentAmount = mortgage.calculateMonthPercent(amount);
        Assertions.assertEquals(fixedAmount-percentAmount, mortgage.calculateMainMonthlyAmount(amount));
    }

    @Test
    public void testDownPaymentApplying(){

        int percent = 1;
        int amount = 120000;
        int downPayment = 0;
        int numberOfMonth = 30;
        Mortgage mortgage = new Mortgage(percent, numberOfMonth, downPayment, amount);
        int nextDownPayment = 50000;
        mortgage.applyDownPayment(nextDownPayment);
        double newAmount = (amount - nextDownPayment);
        Assertions.assertEquals(newAmount, mortgage.getAmount());
        Assertions.assertEquals(mortgage.calculateFixedMonthAmount(), mortgage.getFixedMonthAmount());
    }
}
