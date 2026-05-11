package lab9;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> numere = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista initiala: " + numere);

        int suma = numere.stream()
                .reduce(0, Integer::sum);
        System.out.println("a) Suma elementelor este: " + suma);

        int maxim = numere.stream()
                .max(Comparator.naturalOrder())
                .get();

        int minim = numere.stream()
                .min(Comparator.naturalOrder())
                .get();
        System.out.println("b) Valoarea maxima este: " + maxim + ", iar valoarea minima este: " + minim);

        List<Integer> numereFiltrate = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("c) Lista filtrata: " + numereFiltrate);

        List<Double> numereDouble = numere.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());
        System.out.println("d) Lista mapata la Double: " + numereDouble);

        boolean contine12 = numere.stream()
                .anyMatch(n -> n == 12);
        System.out.println("e) Exista valoarea 12? " + (contine12 ? "Da" : "Nu"));
    }
}