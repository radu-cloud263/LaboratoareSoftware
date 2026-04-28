package lab5;

import java.util.Scanner;

public class AppLab5 {
    static void main(String args[]) {
        AdvancedCalculator calculator = new AdvancedCalculator(10);
        int result = calculator.add(5).subtract(3).multiply(2).divide(3).result();
        System.out.println("a) " + result);

    }
}
