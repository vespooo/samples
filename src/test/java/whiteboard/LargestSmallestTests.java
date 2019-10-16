package whiteboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LargestSmallestTests {

    @ParameterizedTest//not launching alone (jupiter failed), only whole test class
    @MethodSource("parameters")
    void countSwaps(int[] arr, int[] expected){

        Assertions.assertArrayEquals(expected, LargestSmallest.rearrange(arr));
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30},
                             new int[]{30,0,29,1,28,2,27,3,26,4,25,5,24,6,23,7,22,8,21,9,20,10,19,11,18,12,17,13,16,14,15})
        );
    }

}
