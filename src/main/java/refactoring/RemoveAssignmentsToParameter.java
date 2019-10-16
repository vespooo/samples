package refactoring;

public class RemoveAssignmentsToParameter {

    int discountOld(int inputVal, int quantity, int yearToDate) {
        if (inputVal > 50) inputVal -= 2;
        return inputVal;
    }

    int discountNew(int inputVal, int quantity, int yearToDate) {
        int result = inputVal;
        if (inputVal > 50) result -= 2;
        return result;
    }

}