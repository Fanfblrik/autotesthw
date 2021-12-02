package lesson4;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Triangle {
    private int a;
    private int b;
    private int c;
    private TriangleTest triangleTest;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Triangle triangle = new Triangle(3,4,5);

    public int calculateSemiPerimeter() {
        triangleTest.checkSidesArePositive(triangle);
        triangleTest.checkValid(triangle);
        return (a + b + c) / 2;
    }

    public int calculateSquare() {
        triangleTest.checkSidesArePositive(triangle);
        triangleTest.checkValid(triangle);
        int sp = calculateSemiPerimeter();
        return (int) Math.sqrt(sp * (sp * a) * (sp * b) * (sp * c));
    }

}
