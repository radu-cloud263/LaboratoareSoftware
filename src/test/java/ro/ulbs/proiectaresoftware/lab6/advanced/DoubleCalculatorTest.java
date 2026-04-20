package ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleCalculatorTest {

    private DoubleCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new DoubleCalculator();
    }


    @Test
    public void testWithDecimals() {
        calculator.init();

        double rezultat = calculator.add(10.5).subtract(0.2).multiply(2.0).result();

        Assertions.assertEquals(20.6, rezultat, 0.0001);
    }


    @Test
    public void testWithNegatives() {
        calculator.init();
        double rezultat = calculator.add(-5.5).divide(2.0).result();
        Assertions.assertEquals(-2.75, rezultat, 0.0001);
    }


    @Test
    public void testDivideBy0() {
        calculator.init();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.add(10.0).divide(0.0).result();
        });
    }
}
