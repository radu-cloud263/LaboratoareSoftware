package ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewIntCalculatorTest {

    private NewIntCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new NewIntCalculator();
    }

    @Test
    public void testAddPositive() {

        calculator.init();

        int rezultat = calculator.add(10).add(5).result();

        Assertions.assertEquals(15, rezultat);
    }

    @Test
    public void testAddNegative() {
        calculator.init();

        int rezultat = calculator.add(-10).add(5).result();
        Assertions.assertEquals(-5, rezultat);
    }

    @Test
    public void testMultiplyby0() {
        calculator.init();

        int rezultat = calculator.add(5).multiply(0).result();

        Assertions.assertEquals(0, rezultat);
    }

    @Test
    public void testDividePositive() {
        calculator.init();

        int rezultat = calculator.add(10).divide(5).result();

        Assertions.assertEquals(2, rezultat);
    }

    @Test
    public void testDivideBy0() {
        calculator.init();


        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.add(10).divide(0).result();
        });
    }
}