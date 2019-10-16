package samples.credit;

import samples.credit.entity.House;
import samples.credit.entity.Mortgage;
import samples.credit.entity.Rent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonthMortgageTest {

    @Test
    public void testNullMortgage(){
        House house = new House(450000, 300, 0.866, 120);
        Mortgage mortgage = new Mortgage(5, 30, 50000, house.getAmount());
        Rent rent = new Rent(3150, 7000);
        MonthMortgage monthMortgage = MonthMortgage.nullMortgage(house, mortgage);

        Assertions.assertEquals(400000, monthMortgage.getAmountLeft());
        Assertions.assertEquals(0, monthMortgage.getCollectedAmount());
        Assertions.assertEquals(0, monthMortgage.getOverpaid());
        Assertions.assertEquals(0, monthMortgage.getCurrentMonthCollectedAmount());
        Assertions.assertEquals(0, monthMortgage.getPercentAmount());
        Assertions.assertEquals(0, monthMortgage.getAdditionalPayment());
        Assertions.assertEquals(0, monthMortgage.getMainAmount());
        Assertions.assertEquals(0, monthMortgage.getMonthNumber());
    }

    @Test
    public void testFirstMonthMortgage(){
        House house = new House(450000, 300, 0.866, 120);
        Mortgage mortgage = new Mortgage(5, 30, 50000, house.getAmount());
        Rent rent = new Rent(3150, 7000);
        MonthMortgage nullMonthMortgage = MonthMortgage.nullMortgage(house, mortgage);
        MonthMortgage monthMortgage = new MonthMortgage(mortgage, 7000, nullMonthMortgage);
        double monthPercent = mortgage.calculateMonthPercent(400000);
        double monthMainAmount = mortgage.getFixedMonthAmount()-monthPercent;
        double collectedThisMonth = 7000 + monthMainAmount;

        Assertions.assertEquals(400000 - collectedThisMonth, monthMortgage.getAmountLeft());
        Assertions.assertEquals(monthPercent, monthMortgage.getPercentAmount());
        Assertions.assertEquals(monthMainAmount, monthMortgage.getMainAmount());
        Assertions.assertEquals(collectedThisMonth, monthMortgage.getCollectedAmount());
        Assertions.assertEquals(monthPercent, monthMortgage.getOverpaid());
        Assertions.assertEquals(collectedThisMonth, monthMortgage.getCurrentMonthCollectedAmount());
        Assertions.assertEquals(7000, monthMortgage.getAdditionalPayment());
        Assertions.assertEquals(1, monthMortgage.getMonthNumber());
    }

    @Test
    public void testSecondMonthMortgage(){
        House house = new House(450000, 300, 0.866, 120);
        Mortgage mortgage = new Mortgage(5, 30, 50000, house.getAmount());

        MonthMortgage nullMonthMortgage = MonthMortgage.nullMortgage(house, mortgage);
        MonthMortgage monthMortgage1 = new MonthMortgage(mortgage, 7000, nullMonthMortgage);
        MonthMortgage monthMortgage2 = new MonthMortgage(mortgage, 7000, monthMortgage1);
        double collectedInFirstMont = 7000 + monthMortgage1.getMainAmount();
        double collectedInSecondMonths = 7000 + monthMortgage2.getMainAmount();
        double amountLeft = 400000 - (collectedInFirstMont + collectedInSecondMonths);
        double monthPercent1 = mortgage.calculateMonthPercent(400000);
        double monthPercent2 = mortgage.calculateMonthPercent(monthMortgage1.getAmountLeft());
        double monthMainAmount = mortgage.getFixedMonthAmount()-monthPercent2;

        Assertions.assertEquals(amountLeft, monthMortgage2.getAmountLeft());
        Assertions.assertEquals(monthPercent2, monthMortgage2.getPercentAmount());
        Assertions.assertEquals(monthMainAmount, monthMortgage2.getMainAmount());
        Assertions.assertEquals(collectedInSecondMonths+collectedInFirstMont, monthMortgage2.getCollectedAmount());
        Assertions.assertEquals(monthPercent1 +monthPercent2, monthMortgage2.getOverpaid());
        Assertions.assertEquals(collectedInSecondMonths, monthMortgage2.getCurrentMonthCollectedAmount());
        Assertions.assertEquals(7000, monthMortgage2.getAdditionalPayment());
        Assertions.assertEquals(2, monthMortgage2.getMonthNumber());
    }
}
