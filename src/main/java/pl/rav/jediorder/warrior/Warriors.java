package pl.rav.jediorder.warrior;

import lombok.Getter;
import lombok.ToString;
import pl.rav.jediorder.orders.Order;
import pl.rav.jediorder.support.Util;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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
public class Warriors {

//    private static int sithID = 0;
//    private static int jediID = 0;

    @Getter
//    private static Map<String, Warrior> jedi = new LinkedHashMap<>();
    private static Order jedi = new Order(REPUBLIC, "Star", new LinkedHashMap<>());

    @Getter
//    private static Map<String, Warrior> sith = new LinkedHashMap<>();
    private static Order sith = new Order(EMPIRE, "Sword", new LinkedHashMap<>());

    static {
//        Order GalacticRepublic = new Order(REPUBLIC, "Star", Collections.emptyList());
//        Order GalacticEmpire = new Order(EMPIRE, "Sword", Collections.emptyList());
//        orders.put("republic", GalacticRepublic);
//        orders.put("empire", GalacticEmpire);

//        masters.put("Yoda", new Warrior(mastersID++, "Master Yoda", LIGHT, REPUBLIC, G_MASTER, DUAL_PHASE_LIGHTSABER, 940, YODA, UNKNOWN, YODANIN, MALE,null));    // jak tu sprytnie i inteligientnie:) obejść null ?
//        masters.put("Vader", new Warrior(mastersID++, "Darth Vader", DARK, EMPIRE, G_MASTER, SITH_LIGHTSABER, 890, VADER, TATOOINE, HUMAN, MALE,null));    // jak tu sprytnie i inteligientnie:) obejść null ?
//        masters.put("Palpatine", new Warrior(mastersID++, "Darth Sidious", DARK, EMPIRE, G_MASTER, SITH_LIGHTSABER, 930, PALPATINE, NABOO, HUMAN, MALE,null));    // jak tu sprytnie i inteligientnie:) obejść null ?

        jedi.addWarrior(new Warrior("Master Yoda", LIGHT, REPUBLIC, G_MASTER, DUAL_PHASE_LIGHTSABER, 940, YODA, UNKNOWN, YODANIN, MALE, M_JEDI));
        jedi.addWarrior(new Warrior("Qui-Gon Jinn", LIGHT, REPUBLIC, MASTER, GREAT_LIGHTSABER, 870, QUIGON, CORUSCANT, HUMAN, MALE, M_YODA));
        jedi.addWarrior(new Warrior("Obi-Wan Kenobi", LIGHT, REPUBLIC, MASTER, SPLIT_SABER, 830, OBIWAN, STEWJON, HUMAN, MALE, M_YODA));
        jedi.addWarrior(new Warrior("Luke Skywalker", LIGHT, REPUBLIC, PADAWAN, SPLIT_SABER, 660, LUKE, TATOOINE, HUMAN, MALE, M_YODA));

        sith.addWarrior(new Warrior("Darth Sidious", DARK, EMPIRE, G_MASTER, SITH_LIGHTSABER, 930, PALPATINE, NABOO, HUMAN, MALE, M_SITH));
        sith.addWarrior(new Warrior("Darth Vader", DARK, EMPIRE, G_MASTER, SITH_LIGHTSABER, 890, VADER, TATOOINE, HUMAN, MALE, M_SIDIOUS));
        sith.addWarrior(new Warrior("Darth Maul", DARK, EMPIRE, ADEPT, SITH_LIGHTSABER, 790, MAUL, DATHOMIR, DATHMIRIAN, MALE, M_VADER));
        sith.addWarrior(new Warrior("Kylo Ren", DARK, EMPIRE, ADEPT, HILT_LIGHTSABER, 770, REN, CHANDRILLA, HUMAN, MALE, M_VADER));
        sith.addWarrior(new Warrior("Leader Snoke", DARK, EMPIRE, MASTER, SITH_LIGHTSABER, 910, SNOKE, EXEGOL, HUMANOID, MALE, M_SIDIOUS));


    }

    public static boolean addWarriorToOrder(Warrior warrior) {
        if (LIGHT.equals(warrior.getSide())) {
            jedi.addWarrior(warrior);
            return true;
        }
        if (DARK.equals(warrior.getSide())) {
            sith.addWarrior(warrior);
            return true;
        }
        return false;
    }

    public static void printOrder(Order order) {
        System.out.println("The " + Util.BLUE + order.getName().getDesc() + Util.RESET + " warriors:");

        AtomicInteger counter = new AtomicInteger(1);
        order.getWarriors().forEach((k, v) -> {
            System.out.printf("%-2d. %-17s (%s)\n", counter.getAndIncrement(), k, v);
        });
    }

}
