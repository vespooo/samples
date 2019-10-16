package samples.credit;

import samples.credit.entity.expanse.Expense;
import samples.credit.entity.expanse.MortgageExpense;
import samples.credit.entity.income.Income;
import samples.credit.entity.income.SalaryIncome;
import samples.credit.service.Calculator;
import samples.credit.service.CalculatorImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProbeCalculationTest {
    @Test
    public void test(){
        Calculator calculator = new CalculatorImpl();
        List<Income> incomes = new ArrayList<>();
        incomes.add(new SalaryIncome());

        List<Expense> expenses = new ArrayList<>();
        expenses.add(new MortgageExpense());
        calculator.calculateMortgagePaymentList(new PaidHouseCondition(), incomes, expenses);
    }
}
