package lesson4;

import lombok.*;

@Data
@NoArgsConstructor
public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int calculatePerimeter() {
        checkSidesArePositive();
        checkValid();
        return a + b + c;
    }

    public int calculateSemiPerimeter() {
        checkSidesArePositive();
        checkValid();
        return (a + b + c) / 2;
    }

    public int calculateSquare() {
        checkSidesArePositive();
        checkValid();
        int sp = calculateSemiPerimeter();
        return (int) Math.sqrt(sp * (sp * a) * (sp * b) * (sp * c));
    }
    public void checkSidesArePositive() {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("The sides must be positive");
        }
    }

    public void checkValid() {
        long max = Math.max(Math.max(a, b), c);
        if (max >= (a + b + c - max)) {
            throw new IllegalArgumentException("The any two sides must be greater than other side");
        }
    }

}
