package credit.entity.expanse;

import credit.entity.Mortgage;
import credit.entity.Probe;

public class MortgageExpense implements Expense {

    private MortgageStrategy strategy;
    private Mortgage mortgage;

    @Override
    public double calculate(Probe probe) {
        strategy.implement(mortgage);
        return 0;
    }
}
