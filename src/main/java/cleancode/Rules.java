package cleancode;

public class Rules {

    //comments must be present, be adequate and full

    //builds must execute with one and only one step

    //functions:
    //0-2 arguments,
    // no flags in arguments (or any selectors that make code change behavior according this selector), it's sign of two responsibility
    //only one output, without side effects

    //general:
    //implement expected behavior
    //check all special conditions, even you think it'll never happen
    //do not override that was working correct or disable tests
    //if there are more than one switch or if-else for one parameter in the code, it has to be an polymorphism
    //chose right level of abstraction(parent or child ) and right class for methods and variables according naming and physical(like in real world) relations
    //base class shouldn't know nothing about his child
    //declare variables and private methods close to usage
    // use the same name for the same purposes(if you use variable response, don't name it answer in another place, use the same name everywhere)
    //if code use a lot of variables and meth of another class, this code have to be in that class
    //static method could be only if they can't be polymorphic(change behavior with the same name(goal))
    //Replace Magic Numbers with Named Constants
    //encapsulate(extract meth) conditions to quick understanding of what condition about, and don't use !(negatives of conditions): if (shouldBeDeleted(timer))
    //if it has to be coupling let it be obvious:
//    public class MoogDiver {
//        Gradient gradient;
//        List<Spline> splines;
//        public void dive(String reason) {
//            saturateGradient();//hear this function should run at first, bu this is not obvious
//            reticulateSplines();
//            diveForMoog(reason);
//        }
// ...
//    }
//    AAA better solution is:
//    public class MoogDiver {
//        Gradient gradient;
//        List<Spline> splines;
//        public void dive(String reason) {
//            Gradient gradient = saturateGradient();
//            List<Spline> splines = reticulateSplines(gradient);
//            diveForMoog(splines, reason);
//        }
// ...
//    }

    //there is only one reason of inner classes: if this utility private class for upper class




}
