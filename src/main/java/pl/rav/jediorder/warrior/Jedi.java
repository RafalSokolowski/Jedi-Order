package pl.rav.jediorder.warrior;

import lombok.Getter;
import lombok.ToString;
import pl.rav.jediorder.orders.Order;

import java.util.*;

import static pl.rav.jediorder.warrior.types.Appearance.*;
import static pl.rav.jediorder.warrior.types.Gender.*;
import static pl.rav.jediorder.warrior.types.Lightsaber.*;
import static pl.rav.jediorder.warrior.types.Planet.*;
import static pl.rav.jediorder.warrior.types.Side.*;
import static pl.rav.jediorder.warrior.types.Grade.*;
import static pl.rav.jediorder.warrior.types.Species.*;
import static pl.rav.jediorder.warrior.types.OrderName.*;
import static pl.rav.jediorder.warrior.types.Master.*;


@ToString
public class Jedi {

    private static int mastersID = 0;
    private static int jediID = 0;

    @Getter
    private static Map<String, Warrior> masters = new LinkedHashMap<>();

    @Getter
    private static Map<String, Order> orders = new LinkedHashMap<>();

    @Getter
    private static Map<String, Warrior> jedi = new LinkedHashMap<>();

    static {
        Order GalacticRepublic = new Order(REPUBLIC, "Star", Collections.emptyList());
        Order GalacticEmpire = new Order (EMPIRE, "Sword", Collections.emptyList());
        orders.put("republic", GalacticRepublic);
        orders.put("empire", GalacticEmpire);

//        masters.put("Yoda", new Warrior(mastersID++, "Master Yoda", LIGHT, REPUBLIC, G_MASTER, DUAL_PHASE_LIGHTSABER, 940, YODA, UNKNOWN, YODANIN, MALE,null));    // jak tu sprytnie i inteligientnie:) obejść null ?
//        masters.put("Vader", new Warrior(mastersID++, "Darth Vader", DARK, EMPIRE, G_MASTER, SITH_LIGHTSABER, 890, VADER, TATOOINE, HUMAN, MALE,null));    // jak tu sprytnie i inteligientnie:) obejść null ?
//        masters.put("Palpatine", new Warrior(mastersID++, "Darth Sidious", DARK, EMPIRE, G_MASTER, SITH_LIGHTSABER, 930, PALPATINE, NABOO, HUMAN, MALE,null));    // jak tu sprytnie i inteligientnie:) obejść null ?

        jedi.put("Qui-Gon Jinn", new Warrior(jediID++, "Qui-Gon Jinn", LIGHT, REPUBLIC, MASTER, GREAT_LIGHTSABER, 870, QUIGON, CORUSCANT, HUMAN, MALE, M_YODA));
        jedi.put("Obi-Wan Kenobi", new Warrior(jediID++, "Obi-Wan Kenobi", LIGHT, REPUBLIC, MASTER, SPLIT_SABER, 830, OBIWAN, STEWJON, HUMAN, MALE, M_YODA));
        jedi.put("Luke Skywalker", new Warrior(jediID++, "Luke Skywalker", LIGHT, REPUBLIC, PADAWAN, SPLIT_SABER, 660, LUKE, TATOOINE, HUMAN, MALE, M_YODA));

    }

}
