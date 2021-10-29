package lab1;

import java.time.LocalDate;

public class Main {
    public static void main(String [] args) {
        System.out.println("Hello world!");
        SumCalculator calculator = new SumCalculator();
        System.out.println(calculator.sum(1, 2));
        System.out.println(calculator.sum("Emese", "Mathe"));

        System.out.println(LocalDate.now());
    }
}
