package lesson4;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TriangleTest {

    public void checkSidesArePositive(Triangle triangle) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("The sides must be positive");
        }
    }

    public void checkValid(Triangle triangle) {
        long max = Math.max(Math.max(a, b), c);
        if (max >= (a + b + c - max)) {
            throw new IllegalArgumentException("The any two sides must be greater than other side");
        }
    }

}
