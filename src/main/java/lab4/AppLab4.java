package lab4;

import java.util.HashMap;
import java.util.Map;

public class AppLab4 {
    static void main(String[] args) {

        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor",
                "Cluj","Simina", "Alba-Iulia","Marius", "Medias", "Mihai", "Cisnadie","Daniela", "Sibiu");

        System.out.println("Instanta initiala 'varste':");
        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ani");
        }

        varste.put("Vlad", 19);
        varste.put("Iulia", 19);

        System.out.println("\n Instanta 'varste' dupa adaugarea lui Vlad si Iulia:");
        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ani");
        }

        HashMap<String, Tanar> tineri = new HashMap<>();

        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            String prenume = entry.getKey();
            int varsta = entry.getValue();

            String adresa = adrese.getOrDefault(prenume, "Unknown");

            Tanar tanar = new Tanar(prenume, varsta, adresa);

            tineri.put(prenume, tanar);
        }

        System.out.println("\nContinutul instantei 'tineri':");
        for (Map.Entry<String, Tanar> entry : tineri.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " | Valoare: " + entry.getValue().toString());
        }
    }
}
