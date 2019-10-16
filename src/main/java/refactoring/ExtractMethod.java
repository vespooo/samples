package refactoring;

/**
 *
 */
public class ExtractMethod {
    private String _name;

    void printOwingOld(double amount) {
        printBanner();
        //print details
        System.out.println ("name:" + _name);
        System.out.println ("amount" + amount);
    }

    void printOwingNew(double amount) {
        printBanner();
        printDetails(amount);

    }

    private void printDetails(double amount) {
        System.out.println ("name:" + _name);
        System.out.println ("amount" + amount);
    }

    private void printBanner() {

    }

}
