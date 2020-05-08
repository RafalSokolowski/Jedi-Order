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


@ToString
public class Jedi {

    @Getter
    private static Map<String, Order> orders = new HashMap<>();

    @Getter
    private static Map<String, Warrior> jedi = new LinkedHashMap<>();

    static {
        Order grandArmy = new Order("Grand Army of the Republic", "Star", Collections.emptyList());
        Order praetorian = new Order ("Republic Praetorian", "Sword", Collections.emptyList());
        orders.put("Grand Army", grandArmy);
        orders.put("Praetorian", praetorian);

        jedi.put("Yoda", new Warrior(0, "Yoda", LIGHT, grandArmy, G_MASTER, DUAL_PHASE_LIGHTSABER, 990, YODA, UNKNOWN, YODANIN, MALE,null));    // jak tu obejść null ?
        jedi.put("Qui-Gon Jinn", new Warrior(1, "Qui-Gon Jinn", LIGHT, grandArmy, MASTER, GREAT_LIGHTSABER, 870, QUIGON, CORUSCANT, HUMAN, MALE, jedi.get("Yoda")));
        jedi.put("Obi-Wan Kenobi", new Warrior(2, "Obi-Wan Kenobi", LIGHT, grandArmy, MASTER, SPLIT_SABER, 830, OBIWAN, STEWJON, HUMAN, MALE, jedi.get("Yoda")));
        jedi.put("Luke Skywalker", new Warrior(3, "Luke Skywalker", LIGHT, grandArmy, PADAWAN, SPLIT_SABER, 660, LUKE, TATOOINE, HUMAN, MALE, jedi.get("Yoda")));

    }

}
