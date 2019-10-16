package whiteboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinimumSwapsToBringTogetherTests {

    @ParameterizedTest//not launching alone (jupiter failed), only whole test class
    @MethodSource("parameters")
    void countSwaps(int[] arr, int k, int expected){

        Assertions.assertEquals(expected, MinimumSwapsToBringElTogether.countSwaps(arr, k));
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{}, 0, 0),
                Arguments.of(new int[]{1}, 0, 0),
                Arguments.of(new int[]{1, 2}, 3, 0),
                Arguments.of(new int[]{5, 1, 2}, 3, 0),
                Arguments.of(new int[]{5, 1, 2, 9}, 3, 0),
                Arguments.of(new int[]{5, 1, 2, 9, 3}, 3, 1),
                Arguments.of(new int[]{3, 5, 1, 2, 9}, 3, 1),
                Arguments.of(new int[]{3, 5, 1, 2, 9, 4}, 4, 1),
                Arguments.of(new int[]{3, 5, 1, 9, 2, 6, 4}, 4, 2),
                Arguments.of(new int[]{3, 9, 8, 10, 13, 4, 5, 1, 11, 12, 7, 6}, 6, 2),
                Arguments.of(new int[]{3, 9, 8, 10, 13, 4, 5, 1, 11, 12, 7, 6,0}, 6, 3),
                Arguments.of(new int[]{3, 7, 10, 4, 8, 11, 2, 9, 13, 1}, 3, 2)
        );
    }

}
