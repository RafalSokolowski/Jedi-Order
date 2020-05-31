package pl.rav.jediorder.support;


import org.springframework.web.client.RestTemplate;
import pl.rav.jediorder.warrior.SwapiWarriorByID;
import pl.rav.jediorder.warrior.SwapiWarriorBySearch;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MainTest {

    public static void main(String[] args) {



        SwapiWarriorBySearch test = new RestTemplate().getForObject("https://swapi.dev/api/people/?search=skywalker", SwapiWarriorBySearch.class);
        System.out.println("Result:");

        System.out.println(test.getCount());
        System.out.println(test.getNext());
        System.out.println(test.getPrevious());
        System.out.println(Arrays.toString(test.getResults()));



    }
}
