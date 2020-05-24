package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Planet {
    UNKNOWN("Unknown"),         // Yoda:)
    NABOO("Naboo"),             // Palpatine
    CORUSCANT("Coruscant"),     // Qui-Gon Jinn
    STEWJON("Stewjon"),         // Obi-Wan Kenobi
    TATOOINE("Tatooine"),       // Luke Skywalker
    DATHOMIR("Dathomir"),       // Darth Maul
    CHANDRILLA("Chandrilla"),   // Kylo Ren
    EXEGOL("Exegol");           // Snoke
    private String desc;
}






