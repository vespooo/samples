package cleancode;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ClassThrowException {

    public void methodWithUncheckedException1(){
        try {
            FileReader file = new FileReader("C:\\test\\a.txt");
            int i = Integer.parseInt("3");

        }catch (FileNotFoundException e){
            throw new RuntimeException("RuntimeException is unchecked");
        }
    }

    public void methodWithUncheckedException2(){
        try {
            FileReader file = new FileReader("C:\\test\\a.txt");
            int i = Integer.parseInt("3");

        }catch (FileNotFoundException e){
            throw new Error("Error is unchecked too");
        }
    }

    public void methodWithUncheckedException() throws Exception {
        try {
            FileReader file = new FileReader("C:\\test\\a.txt");
            int i = Integer.parseInt("3");

        }catch (FileNotFoundException e){
            throw new Exception("Exception is checked, you must add the exception to the method signature ");
        }
    }
}
