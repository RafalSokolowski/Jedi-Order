package pl.rav.jediorder.support;

import pl.rav.jediorder.Jedi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class MainTest {

    public static void main(String[] args) {

        LinkedList<String> test = new LinkedList<>();  // tworzę Listę
        test.add("ABC");                               // dodaje elementy do Listy
        test.add("CBA");
        test.add("ACB");

        Map<String, LinkedList<String>> mapka = new TreeMap<>();    // tworzę Mapę
        mapka.put("ABC", test);                                    // dodaje element do Mapy

        mapka.put("EFG",new LinkedList<>(Arrays.asList("GFE","FGE")));  // dodam sobie 2ga aby bylo urozmaicenie :)

        mapka.get("ABC").forEach(value-> System.out.print(value + ", "));          // wyswietlam sobie zawartosc List, uzywam tu forEach + lambda Java8 (aby było szybciej ale możesz zrobic to dowolnie w pętli, zresztą to jest pętla tylko jednolinijkowa :)
        System.out.println();
        mapka.get("EFG").forEach(value-> System.out.print(value + ", "));
        System.out.println();

        mapka.get("ABC").add("BAC");// wyciągam daną listę poprzez klucz dodaje wartość i done :)
        mapka.get("ABC").forEach(value-> System.out.print(value + ", ")); //jest dodane :)

    }
}
