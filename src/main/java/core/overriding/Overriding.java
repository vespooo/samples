package core.overriding;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

public class Overriding {

    void test() throws IOException {
        Child child = new Child();
        child.meth(new ChildType());
    }
    class Parent{
        public ParentType meth(ParentType parentType){

            return new ChildType();
            }

        protected ParentType meth1(ParentType parentType) throws Exception { throw new Exception();}

        ParentType meth2(ParentType parentType){ return new ChildType();}
    }

    class Child extends Parent{
        @Override
        public /*protected->default->private weaker*/ChildType meth(ParentType parentType) /*throws IOException not allowed*/{
            //throw new IOException();
            return new ChildType();

        }

        @Override
        public /* defaulte is weaker than protected*/ ParentType meth1(ParentType parentType)/*allowed to not throw exc*/{ return new ChildType();}

        @Override
        protected ParentType meth2(ParentType parentType){

            return super.meth2(new ChildType());}

    }
    class ParentType{

    }
    class ChildType extends ParentType{

    }
}
