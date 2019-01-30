package credit;

import credit.entity.House;
import credit.entity.Mortgage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonthBudgetTest {

    @Test
    public void testNullExpenses(){
        House house = new House(450000, 300, 0.866, 120);
        Mortgage mortgage = new Mortgage(5, 30, 50000, house.getAmount());

        MonthBudget monthBudget = MonthBudget.nullExpenses(MonthMortgage.nullMortgage(house, mortgage));

        Assertions.assertEquals(0, monthBudget.getMonthNumber());
        Assertions.assertEquals(0, monthBudget.getCollectedAmount());
        Assertions.assertEquals(0, monthBudget.getExpenses());
    }

    @Test
    public void testFirstMonthExpenses(){
        House house = new House(450000, 300, 0.866, 120);
        Mortgage mortgage = new Mortgage(5, 30, 50000, house.getAmount());

        MonthMortgage nullMortgage = MonthMortgage.nullMortgage(house, mortgage);
        MonthMortgage firstMonthMortgage = new MonthMortgage(mortgage, 7000, nullMortgage);
        MonthBudget nullMonthBudget = MonthBudget.nullExpenses(nullMortgage);
        MonthBudget firstMonthBudget = new MonthBudget(nullMonthBudget, nullMortgage, 3000, 3000);

        Assertions.assertEquals(1, firstMonthBudget.getMonthNumber());
        Assertions.assertEquals(3000, firstMonthBudget.getCollectedAmount());
        Assertions.assertEquals(3000, firstMonthBudget.getExpenses());
    }
}
