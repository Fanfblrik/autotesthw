package ru.GB;

import lesson4.Triangle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest extends Triangle {

    public static Stream<Arguments> triangleForPerimeter() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 12),
                Arguments.of(new Triangle(3, 3, 3), 9),
                Arguments.of(new Triangle(3, 4, 6), 13)
        );
    }

    @ParameterizedTest(name = "Рассчитать периметр")
    @MethodSource("triangleForPerimeter")
    void trianglePerimeterTest(Triangle triangle, int expectedResult) {
        int actualResult = triangle.calculatePerimeter(); // Act
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void catchExceptionByJunitTest() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 1, 50)
                .calculatePerimeter());
        assertEquals("The any two sides must be greater than other side", illegalArgumentException.getMessage());
    }

}
