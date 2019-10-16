package samples.credit;

import samples.credit.entity.House;
import samples.credit.entity.Mortgage;
import samples.credit.entity.Rent;

import java.util.ArrayList;
import java.util.List;

public class BudgetList {

    private List<MonthBudget> payments;


    BudgetList(House house, Mortgage mortgage, Rent rent, int additionalPayment, int mortgageStartingMonth){
        List<MonthBudget> payments = new ArrayList<>();
        MonthBudget previousExpenses = MonthBudget.nullExpenses(MonthMortgage.nullMortgage(house, mortgage));
        for(int i=1; i<mortgageStartingMonth; i++){
            previousExpenses = new MonthBudget(previousExpenses,MonthMortgage.nullMortgage(house, mortgage), rent.getRentCost(),  rent.getFreeAmount());
            payments.add(previousExpenses);
        }
        mortgage.applyDownPayment(previousExpenses.getCollectedAmount());
                MonthMortgage previousMonthMortgage = MonthMortgage.nullMortgage(house, mortgage);
        while(previousMonthMortgage.getAmountLeft()>0){
            MonthMortgage monthMortgage = new MonthMortgage(mortgage, additionalPayment, previousMonthMortgage);
            previousMonthMortgage = monthMortgage;
            previousExpenses= new MonthBudget(previousExpenses, monthMortgage,  monthExpensesWithHouse(monthMortgage, house), monthMortgage.getCurrentMonthCollectedAmount());
            payments.add(previousExpenses);
        }
        this.payments = payments;
    }


    private double monthExpensesWithHouse(MonthMortgage mortgage, House house) {
        return mortgage.getPercentAmount() + house.calculateExpenses();
    }

    public double getWholeExpenses() {
        if (!payments.isEmpty()){
            return payments.get(payments.size()-1).getExpenses();
        }
        return 0;
    }

    public double getWholeCollectedAmount() {
        if (!payments.isEmpty()){
            return payments.get(payments.size()-1).getCollectedAmount();
        }
        return 0;
    }

    public List<MonthBudget> getPayments() {
        return payments;
    }

    public int getNumberOfMonth() {
        if (!payments.isEmpty()){
            return payments.get(payments.size()-1).getMonthNumber();
        }
        return 0;
    }
}
