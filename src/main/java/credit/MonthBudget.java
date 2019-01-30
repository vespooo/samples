package credit;

public class MonthBudget {

    private final MonthMortgage monthMortgage;
    private final int monthNumber;
    private final double expenses;
    private final double collectedAmount;

    public MonthBudget(MonthBudget previousExpenses, MonthMortgage monthMortgage, double monthExpenses, double monthCollectedAmount) {
        this.monthNumber = previousExpenses.monthNumber+1;
        this.monthMortgage = monthMortgage;
        this.expenses = previousExpenses.expenses + monthExpenses;
        this.collectedAmount = previousExpenses.collectedAmount + monthCollectedAmount;
    }

    private MonthBudget(int i, MonthMortgage monthMortgage, int monthExpenses, int monthCollectedAmount) {

        this.monthNumber = i;
        this.monthMortgage = monthMortgage;
        this.expenses = monthExpenses;
        this.collectedAmount = monthCollectedAmount;
    }

    public MonthMortgage getMonthMortgage() {
        return monthMortgage;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public double getExpenses() {
        return expenses;
    }

    public double getCollectedAmount() {
        return collectedAmount;
    }


    public static MonthBudget nullExpenses(MonthMortgage monthMortgage) {
        return new MonthBudget(0, monthMortgage,0, 0);
    }
}
