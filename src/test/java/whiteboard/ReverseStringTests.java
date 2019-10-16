package whiteboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReverseStringTests {

    @ParameterizedTest//not launching alone (jupiter failed), only whole test class
    @MethodSource("parameters")
    void rearrange1approach(String initial, String expected){

        Assertions.assertEquals(expected, ReverseString.reverse(initial));
    }

    private static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("a", "a"),
                Arguments.of("ab", "ba"),
                Arguments.of("abc", "cba"),
                Arguments.of("abcd", "dcba")
        );
    }

}
