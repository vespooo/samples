package designpatterns.creational.builder.onelinebuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneLineBuilderTest {

    @Test
    public void test(){
        String option1 = "hgg";
        String option2 = "uuu";
        OneLineBuilder builder = new OneLineBuilder().addOption1(option1).addOption2(option2);
        Assertions.assertTrue(builder.getOption1().equals(option1));
        Assertions.assertTrue(builder.getOption2().equals(option2));
    }
}
