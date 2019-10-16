package refactoring;

/**
 * replace temp variable with method call
 */
public class ReplaceTempWithQuery {

    private double _quantity;
    private double _itemPrice;

    double oldCode(){
        double basePrice = _quantity * _itemPrice;
        if (basePrice > 1000)
            return basePrice * 0.95;
        else
            return basePrice * 0.98;
    }

    double newCode(){
        if (basePrice() > 1000)
            return basePrice() * 0.95;
        else
            return basePrice() * 0.98;
    }

    private double basePrice() {
        return _quantity * _itemPrice;
    }
}
