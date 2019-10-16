package samples.credit.service;

import samples.credit.StopCondition;
import samples.credit.entity.expanse.Expense;
import samples.credit.entity.income.Income;
import samples.credit.entity.Probe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Calculator {
    public Probe calculateMortgagePaymentList(StopCondition condition, List<Income> incomes, List<Expense> expenses);
}
