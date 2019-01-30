package samples.refactoring;

/**
 * if different meaning values assigned to the same variable, it has to be splitted
 */
public class SplitTemporaryVariable {

    private double _height;
    private double _width;

    void oldCode(){
        double temp = 2 * (_height + _width);
        System.out.println (temp);
        temp = _height * _width;
        System.out.println (temp);
    }

    void newCode(){
        double perimeter = 2 * (_height + _width);
        System.out.println (perimeter);
        double area = _height * _width;
        System.out.println (perimeter);
    }
}
