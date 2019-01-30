package anton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class PoweredArrayTest {

    @Test
    public void emptyArr(){
        PowerArray arr = new PowerArray();
        Assertions.assertTrue(arr.powerArray(new int[]{}).length==0);
    }

    @Test
    public void oneElArr(){
        PowerArray arr = new PowerArray();
        Assertions.assertArrayEquals(new int[]{1},arr.powerArray(new int[]{1}));
    }

    @Test
    public void oneNegativeElArr(){
        PowerArray arr = new PowerArray();
        Assertions.assertArrayEquals(new int[]{4},arr.powerArray(new int[]{-2}));
    }
    @Test
    public void twoElArr(){
        PowerArray arr = new PowerArray();
        Assertions.assertArrayEquals(new int[]{1,4},arr.powerArray(new int[]{-2,1}));
    }

    private static Stream<Arguments> oddElArr(){
        return Stream.of(Arguments.of(new int[]{0,1, 25, 49, 64 }, new int[]{-5,-1,0,7, 8}));
    }
    @ParameterizedTest
    @MethodSource("oddElArr")
    public void oddElArr(int[] expected, int[] source){
        PowerArray arr = new PowerArray();
        Assertions.assertArrayEquals(expected,arr.powerArray(source));
    }

    private static Stream<Arguments> evenElArr(){
        return Stream.of(Arguments.of(new int[]{0,1, 25, 49, 64, 81 }, new int[]{-9, -5,-1,0,7, 8}));
    }
    @ParameterizedTest
    @MethodSource("evenElArr")
    public void evenElArr(int[] expected, int[] source){
        PowerArray arr = new PowerArray();
        Assertions.assertArrayEquals(expected,arr.powerArray(source));
    }

    private static Stream<Arguments> negativeElArr(){
        return Stream.of(Arguments.of(new int[]{1, 9, 25, 64 }, new int[]{-8,-5,-3,-1}));
    }
    @ParameterizedTest
    @MethodSource("negativeElArr")
    public void negativeElArr(int[] expected, int[] source){
        PowerArray arr = new PowerArray();
        Assertions.assertArrayEquals(expected,arr.powerArray(source));
    }

    private static Stream<Arguments> positiveElArr(){
        return Stream.of(Arguments.of(new int[]{4, 25, 49, 100 }, new int[]{2,5,7,10}));
    }
    @ParameterizedTest
    @MethodSource("positiveElArr")
    public void positiveElArr(int[] expected, int[] source){
        PowerArray arr = new PowerArray();
        Assertions.assertArrayEquals(expected,arr.powerArray(source));
    }
}
