package samples.whiteboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DenominationsTest {

    public  Denominations denominations;

    @BeforeEach
    public void before(){
        denominations = new Denominations();
    }

    @Test
    public void oneElementLessThenAmount(){
        Assertions.assertTrue(denominations.findVariants(22, Arrays.asList(21)).size() ==0);
    }
    @Test
    public void oneElementMoreThenAmount(){
        Assertions.assertTrue(denominations.findVariants(22, Arrays.asList(23)).size() ==0);
    }

    @Test
    public void oneElementEqualToAmount(){
        Assertions.assertTrue(denominations.findVariants(22, Arrays.asList(22)).size() ==1);
    }

    @Test
    public void twoElementsSumNotEqualToAmount(){
        Assertions.assertTrue(denominations.findVariants(22, Arrays.asList(10, 28)).size() ==0);
    }

    @Test
    public void twoElementsSumNotEqualToAmount2(){
        Assertions.assertTrue(denominations.findVariants(22, Arrays.asList(8, 10)).size() ==0);
    }

    @Test
    public void twoEqualElementsSumEqualToAmount1(){
        Assertions.assertTrue(denominations.findVariants(22, Arrays.asList(11, 12)).size() ==1);
    }

    @Test
    public void twoEqualElementsSumEqualToAmount2(){
        Assertions.assertEquals(1, denominations.findVariants(22, Arrays.asList(8, 11)).size());
    }

    @Test
    public void fiveElements(){
        List<List<Integer>> variants = denominations.findVariants(4, Arrays.asList(1, 2, 3, 4, 5));
        Assertions.assertEquals(4, variants.size());
    }

    @Test
    public void twoElementsSumEqualToAmount(){
        Assertions.assertEquals(1, denominations.findVariants(22, Arrays.asList(8, 14)).size());
    }
}
