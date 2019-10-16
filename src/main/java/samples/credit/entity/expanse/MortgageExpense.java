package samples.credit.entity.expanse;

import samples.credit.entity.Mortgage;
import samples.credit.entity.Probe;

public class MortgageExpense implements Expense {

    private MortgageStrategy strategy;
    private Mortgage mortgage;

    @Override
    public double calculate(Probe probe) {
        strategy.implement(mortgage);
        return 0;
    }
}
