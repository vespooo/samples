package samples.cleancode.functionsarguments;

public interface FunctionsSamples {
    //good
    void toDoFunction();
    void toDoFunction(Object info);
    void transformThisClassObjectFunction();

    //less good
    //if this method change the state of obj, it has to be in obj's class and it will previous signature
    Object transformAnotherObject(Object obj);
    //why this information is asking, if to do smth, then this to do has to be done in this class
    Object getSomeInfo();

    //bad
    //it's better to throw an Exception or return Special case object
    Object canReturnNull();
    void canAcceptNull();


}
