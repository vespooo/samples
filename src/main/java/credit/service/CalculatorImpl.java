package credit.service;

import credit.StopCondition;
import credit.entity.MonthCalculation;
import credit.entity.expanse.Expense;
import credit.entity.income.Income;
import credit.entity.Probe;

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
