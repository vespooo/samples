package refactoring;

/**
 * replace method call with method body
 */
public class InlineMethod {

    private int _numberOfLateDeliveries;

    int getRatingOld() {
        return (moreThanFiveLateDeliveries()) ? 2 : 1;
    }

    int getRatingNew() {
        return (_numberOfLateDeliveries > 5) ? 2 : 1;
    }

    boolean moreThanFiveLateDeliveries() {
        return _numberOfLateDeliveries > 5;
    }

}
