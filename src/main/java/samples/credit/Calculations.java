package samples.credit;

import samples.credit.entity.House;
import samples.credit.entity.Mortgage;
import samples.credit.entity.Rent;

public class Calculations {
    public static void main(String[] args) {
        House house = new House(450000, 300, 0.866, 120);
        Mortgage credit = new Mortgage(5, 30*12, 30000, house.getAmount());
        Rent rent = new Rent(3150, 0);
        BudgetList mortgage = new BudgetList(house, credit, rent,0,1);
        mortgage.getPayments().stream()
                .forEach(monthExpense -> {
                    BudgetList mortgageStartedNow = new BudgetList(house, credit, rent, 0, monthExpense.getMonthNumber());
                    System.out.format("whole expenses=%f, numberOfMonths=%d || startMonthNumber=%d, whole expenses suspended=%f, numberOfMonths=%d"
                            , mortgage.getWholeExpenses(), mortgage.getNumberOfMonth(), monthExpense.getMonthNumber(),mortgageStartedNow.getWholeExpenses(), mortgageStartedNow.getNumberOfMonth());
                    System.out.println();
                });
    }
}
