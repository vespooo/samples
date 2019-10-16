package samples.credit;

import java.math.BigDecimal;
import java.math.MathContext;

public class DoubleRoundedToTwo {
    private final BigDecimal value;

    public DoubleRoundedToTwo(double value) {
        this.value = new BigDecimal(value, new MathContext(2));
    }

    public BigDecimal getValue() {
        return value;
    }
}
