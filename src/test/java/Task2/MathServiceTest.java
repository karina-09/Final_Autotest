package Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MathServiceTest {

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("Проверка нахождения корней квадратного уравнения через дискриминант")
    void RootsOfTheEquationTest(int a, int b, int c) throws NotFoundAnswerException {
        MathService mathService = new MathService();
        int d = mathService.getD(a, b, c);
        if (d < 0) {
            System.out.printf("По заданным параметрам рассчитан отрицательный дискриминант %s", d);
            Assertions.assertThrows(NotFoundAnswerException.class, () -> {
                mathService.getAnswer(4, 0, 4);
            });
        } else if (d > 0) {
            System.out.printf("По заданным параметрам рассчитан положительный дискриминант %s", d);
            Double x1 = (-b + Math.sqrt(d)) / (2 + a);
            Double x2 = (-b - Math.sqrt(d)) / (2 + a);
            Assertions.assertEquals(x1, mathService.getAnswer(a, b, c).getFirst());
            Assertions.assertEquals(x2, mathService.getAnswer(a, b, c).getSecond());
        } else {
            System.out.printf("По заданным параметрам рассчитан нулевой дискриминант %s", d);
            Double x = (double) ((-b) / (2 * a));
            Assertions.assertEquals(x, mathService.getAnswer(a, b, c).getFirst());
            Assertions.assertEquals(x, mathService.getAnswer(a, b, c).getSecond());
        }
    }
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(4, 0, 4),
                Arguments.of(5, 7, 3),
                Arguments.of(2, -4, 2),
                Arguments.of(2, -2, -2),
                Arguments.of(1, 78, 35),
                Arguments.of(22, 12, 2)
        );
    }
}
