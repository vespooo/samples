package credit.service;

import credit.StopCondition;
import credit.entity.expanse.Expense;
import credit.entity.income.Income;
import credit.entity.Probe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Calculator {
    public Probe calculateMortgagePaymentList(StopCondition condition, List<Income> incomes, List<Expense> expenses);
}
