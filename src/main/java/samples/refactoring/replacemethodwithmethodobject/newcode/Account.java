package samples.refactoring.replacemethodwithmethodobject.newcode;

public class Account {
    int gamma (int inputVal, int quantity, int yearToDate) {
        return  new Gamma(this, inputVal, quantity, yearToDate).calculate();
    }

    public int delta() {
        return 0;
    }
}
