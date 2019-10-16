package whiteboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RearrangeArrayWithIndexesTests {

    private RearrangeArrayWithIndexes service;

    @BeforeEach
    void before(){
        service = new RearrangeArrayWithIndexes();
    }

    @ParameterizedTest//not launching alone (jupiter failed), only whole test class
    @MethodSource("parameters")
    void rearrange1approach(int[] expected, int[] arr){

        Assertions.assertArrayEquals(expected, service.rearrange1approach(arr));
    }

    @ParameterizedTest//not launching alone (jupiter failed), only whole test class
    @MethodSource("parameters")
    void rearrange2approach(int[] expected, int[] arr){

        Assertions.assertArrayEquals(expected, service.rearrange2approach(arr));
    }

    private static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{-1}, new int[]{-1}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{0,1}, new int[]{0,1}),
                Arguments.of(new int[]{0,1}, new int[]{1,0}),
                Arguments.of(new int[]{0,-1}, new int[]{-1,0}),
                Arguments.of(new int[]{0,1,-1}, new int[]{-1,0,1}),
                Arguments.of(new int[]{0,-1, 2}, new int[]{-1,0, 2}),
                Arguments.of(new int[]{0,-1, 2}, new int[]{2,0,-1}),
                Arguments.of(new int[]{0,1,2}, new int[]{1,2,0}),
                Arguments.of(new int[]{0,1,2}, new int[]{2,1,0}),
                Arguments.of(new int[]{-1,1,2,3,4,-1,6,-1,-1,9}, new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}),
                Arguments.of(new int[]{-1,1,2,3,4,-1,6,-1,-1,9}, new int[]{-1, -1, 6, 1, 9, 2, 3, -1, 4, -1}),
                Arguments.of(new int[]{-1,1,2,3,4,5,6,-1,-1,9}, new int[]{-1, 5, 6, 1, 9, 3, 2, -1, 4, -1}),
                Arguments.of(new int[]{0,1,2,3,4,-1,6,-1,-1,9}, new int[]{-1, 0, 6, 1, 9, 3, 2, -1, 4, -1}),
                Arguments.of(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}, new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4})
        );
    }


}
