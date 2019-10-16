package samples.credit.service;

import samples.credit.StopCondition;
import samples.credit.entity.MonthCalculation;
import samples.credit.entity.expanse.Expense;
import samples.credit.entity.income.Income;
import samples.credit.entity.Probe;

import java.util.List;

public class CalculatorImpl implements Calculator {


    @Override
    public Probe calculateMortgagePaymentList(StopCondition condition, List<Income> incomes, List<Expense> expenses) {
        Probe probe = new Probe();
        int month=0;
        while(condition.isLeft()){
            MonthCalculation calculation = new MonthCalculation(++month);
            for(Expense expense : expenses){
                calculation.addExpense(expense.calculate(probe));
            }
        }
        return probe;
    }

}
