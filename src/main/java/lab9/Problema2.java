package lab9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Problema2 {

    public static void main(String[] args) {
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));

        System.out.println("Lista initiala: " + cuvinte);

        List<String> cuvinteFiltrate = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());

        long numarCuvinte = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .count();

        System.out.println("a) Numarul de cuvinte cu >= 5 caractere: " + numarCuvinte);
        System.out.println("   Lista filtrata: " + cuvinteFiltrate);

        List<String> cuvinteOrdonate = cuvinteFiltrate.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("b) Lista noua ordonata: " + cuvinteOrdonate);

        Optional<String> cuvantCuP = cuvinte.stream()
                .filter(c -> c.startsWith("p"))
                .findAny();

        if (cuvantCuP.isPresent()) {
            System.out.println("c) Element care incepe cu 'p': " + cuvantCuP.get());
        } else {
            System.out.println("c) Nu a fost gasit niciun cuvant care începe cu 'p'");
        }
    }
}