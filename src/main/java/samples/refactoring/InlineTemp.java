package samples.refactoring;

/**
 * replace temp variable with variables's value
 */
public class InlineTemp {
    private SubClass anOrder;

    boolean oldCode(){
        double basePrice = anOrder.basePrice();
        return (basePrice > 1000);
    }

    boolean newCode(){
        return (anOrder.basePrice() > 1000);
    }

    private class SubClass {
        public double basePrice() {
            return 0;
        }
    }
}
