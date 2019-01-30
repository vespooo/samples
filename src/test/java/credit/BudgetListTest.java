package credit;

import credit.entity.House;
import credit.entity.Mortgage;
import credit.entity.Rent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BudgetListTest {

    @Test
    public void test(){
        House house = new House(450000, 300, 0.866, 120);
        Mortgage mortgage = new Mortgage(5, 30, 50000, house.getAmount());
        Rent rent = new Rent(3150, 7000);

        BudgetList budgetList = new BudgetList(house, mortgage, rent, 7000, 2);
        MonthBudget firstMonthBudget = budgetList.getPayments().get(0);
        MonthBudget secondMonthBudget = budgetList.getPayments().get(1);

        double firstMonthexp = rent.getRentCost();
        double firstMonthWorth = rent.getFreeAmount();
        double secondMonthExp = firstMonthexp + mortgage.calculateMonthPercent(400000-firstMonthWorth) + house.calculateExpenses();
        double secondMonthWorth = firstMonthWorth + 7000 + secondMonthBudget.getMonthMortgage().getMainAmount();

        Assertions.assertEquals(firstMonthexp, firstMonthBudget.getExpenses());
        Assertions.assertEquals(firstMonthWorth, firstMonthBudget.getCollectedAmount());
        Assertions.assertEquals(secondMonthExp, secondMonthBudget.getExpenses());
        Assertions.assertEquals(secondMonthWorth, secondMonthBudget.getCollectedAmount());
    }
}
