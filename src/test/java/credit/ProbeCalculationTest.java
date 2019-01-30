package credit;

import credit.entity.expanse.Expense;
import credit.entity.expanse.MortgageExpense;
import credit.entity.income.Income;
import credit.entity.income.SalaryIncome;
import credit.service.Calculator;
import credit.service.CalculatorImpl;
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
