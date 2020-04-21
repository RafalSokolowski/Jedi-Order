package pl.rav.jediorder.support;

import pl.rav.jediorder.Jedi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class MainTest {

    public static void main(String[] args) {
        Jedi jedi = new Jedi();
        System.out.println(jedi.getAppearance());




        LinkedList<String> test1 = new LinkedList<>();   // tworzę Listę
        test1.add("string1");                            // dodaje elementy do Listy
        test1.add("string2");
        test1.add("string3");

        Map<String, LinkedList<String>> mapka = new TreeMap<>();    // tworzę Mapę
        mapka.put("klucz1", test1);                                 // dodaje element do Mapy

//        mapka.put("klucz2", (LinkedList) Arrays.asList("string4","string5","string6")); // można też jednolinijkowcem jak na szybko potrzebujesz , ale to raczej bzytki cast i nie sprawdza rzutowania, raczej odradzany przez Java Developerów i InteliJ :)

        mapka.put("klucz3", new LinkedList<>(Arrays.asList("string4","string5","string6")));    // tak lepiej bo utrzymujesz spójność typów

    }
}
